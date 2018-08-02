package ie.rmxsantiago.data.repositories;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;

import ie.rmxsantiago.data.database.MoviesDatabase;
import ie.rmxsantiago.data.remote.tmdb.TmdbRestService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public abstract class BaseRepository {
    protected static String API_KEY = "3661f054fd66a3f8a97df3940ff9e3b0";
    protected static String LANGUAGE = "en-US";
    private static String BASE_URL = "https://api.themoviedb.org/3/";

    protected MoviesDatabase db;
    protected TmdbRestService tmdbRestService;
    private Application application;


    public BaseRepository(Application application) {
        this.application = application;
        db = MoviesDatabase.getDatabase(application);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tmdbRestService = retrofit.create(TmdbRestService.class);
    }

    protected boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
