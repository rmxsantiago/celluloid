package ie.rmxsantiago.data.repositories;

import android.app.Application;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import ie.rmxsantiago.data.database.daos.GenreDAO;
import ie.rmxsantiago.domain.model.common.Genre;
import ie.rmxsantiago.domain.model.reponses.GenreResponse;
import ie.rmxsantiago.domain.repositories.GenreRepository;
import retrofit2.Call;
import retrofit2.Response;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Singleton
public class GenreRepositoryImpl extends BaseRepository implements GenreRepository {
    private static final String TAG = "GenreRepositoryImpl";

    private GenreDAO genreDAO;
    private LiveData<List<Genre>> genreListLiveData;
    private final Executor executor;

    private final MediatorLiveData mediator = new MediatorLiveData();

    public GenreRepositoryImpl(Application application, Executor executor) {
        super(application);

        genreDAO = db.getGenreDAO();
        this.executor = executor;
        //genreListLiveData = genreDAO.returnAllGenders();

        /*
         * Step 1 - This code add the LiveData to a Mediator for listening
         */
        mediator.addSource(genreListLiveData, data -> {
            mediator.removeSource(genreListLiveData);
            if(shouldFetch(data)){
                fetchAllGenresFromNetwork(genreListLiveData);
            }else{
                mediator.addSource(genreListLiveData, newData -> mediator.setValue(data));
            }
        });
    }

    private boolean shouldFetch(Object data) {
        return true;
    }

    public LiveData<List<Genre>> getMovieGenres() {
        //Log.d(TAG, "isNetworkConnected: " + isNetworkConnected());
        //fetchAllGenresFromNetwork();
        //genreListLiveData = genreDAO.returnAllGenders();

        return genreListLiveData;
    }

    /**
     * This method returns a LiveData after a network call.
     * @param genreListLiveData
     * @return
     */
    private LiveData<List<Genre>> getAllGenres(LiveData<List<Genre>> genreListLiveData) {
        refreshData();
        return genreDAO.returnAllGenders();
    }

    /*private LiveData<List<Genre>> getAllGenres(LiveData<List<Genre>> genreListLiveData) {
        final MutableLiveData<List<Genre>> data = new MutableLiveData<>();

        Call<GenreResponse> call = tmdbRestService.listGenre(API_KEY, LANGUAGE);
        call.enqueue(
                new Callback<GenreResponse>() {
                    @Override
                    public void onResponse(Call<GenreResponse> call, Response<GenreResponse> response) {
                        Log.d(TAG, "onResponse");
                        GenreResponse genreResponse = response.body();
                        data.setValue(genreResponse.getGenres());
                        //new InsertGenreAsyncTask(genreDAO, genreResponse.getGenres()).execute();
                    }

                    @Override
                    public void onFailure(Call<GenreResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                        t.printStackTrace();
                    }
                });
        return data;
    }*/

    private void fetchAllGenresFromNetwork(LiveData<List<Genre>> genreListLiveData) {

    }

    private void refreshData() {
        executor.execute(() -> {
            Call<GenreResponse> call = tmdbRestService.listGenre(API_KEY, LANGUAGE);
            try {
                Response<GenreResponse> response = call.execute();
                genreDAO.insert(response.body().getGenres());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    private class InsertGenreAsyncTask extends AsyncTask<Void, Void, Void> {
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

        @Override
        protected void onPostExecute(Void aVoid) {
            mediator.addSource(genreDAO.returnAllGenders(), data -> mediator.setValue(data));
        }
    }
}
