package ie.rmxsantiago.data.robots;

import java.io.IOException;

import ie.rmxsantiago.data.database.daos.MovieDAO;
import ie.rmxsantiago.data.utils.WebServiceHelper;
import ie.rmxsantiago.domain.model.common.Movie;
import ie.rmxsantiago.domain.model.reponses.MoviesByGenreResponse;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class MovieRobot extends BaseRobot{
    private MovieDAO movieDAO;

    public MovieRobot(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }

    public Movie insertMovie() throws IOException {
        String json = WebServiceHelper.fromInputStreamToString("json/genre/genre_getMovies.json");
        MoviesByGenreResponse moviesByGenreResponse = gson.fromJson(json, MoviesByGenreResponse.class);

        Movie movie = moviesByGenreResponse.getResults().get(0);
        this.movieDAO.insert(movie);

        return movie;
    }
}
