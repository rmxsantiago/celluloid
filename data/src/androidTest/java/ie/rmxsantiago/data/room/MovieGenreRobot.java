package ie.rmxsantiago.data.room;

import org.junit.Test;

import ie.rmxsantiago.data.database.daos.MovieGenreDAO;
import ie.rmxsantiago.domain.model.common.MovieGenre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
class MovieGenreRobot {
    private MovieGenreDAO movieGenreDAO;

    public MovieGenreRobot(MovieGenreDAO movieGenreDAO) {
        this.movieGenreDAO = movieGenreDAO;
    }

    @Test
    public void insertMovieGenre(MovieGenre movieGenre) {
        movieGenreDAO.insert(movieGenre);
    }
}
