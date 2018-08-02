package ie.rmxsantiago.data.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import ie.rmxsantiago.data.database.daos.GenreDAO;
import ie.rmxsantiago.domain.model.common.Genre;
import ie.rmxsantiago.domain.model.reponses.GenreResponse;
import ie.rmxsantiago.domain.repositories.GenreRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Singleton
public class GenreRepositoryImpl extends BaseRepository implements GenreRepository {
    private static final String TAG = "GenreRepositoryImpl";

    private GenreDAO genreDAO;
    private LiveData<List<Genre>> genres;

    public GenreRepositoryImpl(Application application) {
        super(application);

        genreDAO = db.getGenreDAO();
        genres = genreDAO.returnAllGenders();
    }

    public LiveData<List<Genre>> getMovieGenres() {
        if(this.isNetworkConnected()) {
            Log.d(TAG, "isNetworkConnected: " + isNetworkConnected());
            loadGenres();
            genres = genreDAO.returnAllGenders();
        }


        return genres;
    }

    private void loadGenres() {
        Call<GenreResponse> call = tmdbRestService.listGenre(API_KEY, LANGUAGE);
        call.enqueue(
                new Callback<GenreResponse>() {
                    @Override
                    public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                        Log.d(TAG, "onResponse");
                        GenreResponse genreResponse = response.body();
                        new InsertGenreAsyncTask(genreDAO, genreResponse.getGenres()).execute();
                    }

                    @Override
                    public void onFailure(Call<GenreResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                        t.printStackTrace();
                    }
                });
    }

    private static class InsertGenreAsyncTask extends AsyncTask<Void, Void, Void> {
        private final GenreDAO genreDAO;
        private final List<Genre> genres;

        InsertGenreAsyncTask(GenreDAO genreDAO, List<Genre> genres) {
            this.genreDAO = genreDAO;
            this.genres = genres;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            genreDAO.insert(genres);
            return null;
        }
    }
}
