package ie.rmxsantiago.celluloid.data.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import ie.rmxsantiago.celluloid.data.remote.pojos.GenreResponse;
import ie.rmxsantiago.celluloid.data.database.MoviesDatabase;
import ie.rmxsantiago.celluloid.data.database.daos.GenreDAO;
import ie.rmxsantiago.celluloid.data.database.model.Genre;
import ie.rmxsantiago.celluloid.data.remote.TmdbRestService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Singleton
public class GenreRepository {
    private static final String TAG = "GenreRepository";
    
    private static String BASE_URL = "https://api.themoviedb.org/3/";
    private static String API_KEY = "3661f054fd66a3f8a97df3940ff9e3b0";
    private static String LANGUAGE = "en-US";

    private TmdbRestService tmdbRestService;
    private GenreDAO genreDAO;

    private LiveData<List<Genre>> genres;

    public GenreRepository(Application application) {
        MoviesDatabase db = MoviesDatabase.getDatabase(application);
        genreDAO = db.genreDAO();
        genres = genreDAO.returnAllGenders();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tmdbRestService = retrofit.create(TmdbRestService.class);
    }

    public LiveData<List<Genre>> getMovieGenres() {
        loadGenres();
        genres = genreDAO.returnAllGenders();

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
            genreDAO.insertGenres(genres);
            return null;
        }
    }
}
