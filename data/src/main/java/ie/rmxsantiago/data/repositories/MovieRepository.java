package ie.rmxsantiago.data.repositories;

import android.app.Application;

import javax.inject.Singleton;

import ie.rmxsantiago.data.database.daos.MovieDAO;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Singleton
public class MovieRepository extends BaseRepository {
    private static final String TAG = "MovieRepository";

    private MovieDAO movieDAO;
    //private LiveData<List<MovieDTO>> listOfMovies;

    public MovieRepository(Application application) {
        super(application);

        //movieDAO = db.getMovieDAO();
        //List<Movies> moviesList = db.
        //listOfMovies =
    }
}
