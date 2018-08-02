package ie.rmxsantiago.data.room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import androidx.test.runner.AndroidJUnit4;
import ie.rmxsantiago.data.robots.GenreRobot;
import ie.rmxsantiago.data.robots.MovieRobot;
import ie.rmxsantiago.domain.model.common.Genre;
import ie.rmxsantiago.domain.model.common.Movie;
import ie.rmxsantiago.domain.model.common.MovieGenre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@RunWith(AndroidJUnit4.class)
public class MovieGenreDaoTest extends BaseDaoTest{
    private MovieRobot movieRobot;
    private GenreRobot genreRobot;
    private MovieGenreRobot movieGenreRobot;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();

        movieRobot = new MovieRobot(database.getMovieDAO());
        genreRobot = new GenreRobot(database.getGenreDAO());
        movieGenreRobot = new MovieGenreRobot(database.getMovieGenreDAO());
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        movieRobot = null;
        genreRobot = null;
    }

    @Test
    public void insert() throws IOException {
        Genre genre = genreRobot.insertGenre();
        Movie movie = movieRobot.insertMovie();

        MovieGenre movieGenre = new MovieGenre(genre.getId(), movie.getId());
        movieGenreRobot.insertMovieGenre(movieGenre);
    }
}
