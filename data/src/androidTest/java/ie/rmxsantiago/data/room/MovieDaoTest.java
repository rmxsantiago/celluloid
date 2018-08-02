package ie.rmxsantiago.data.room;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import androidx.test.runner.AndroidJUnit4;
import ie.rmxsantiago.data.database.daos.MovieDAO;
import ie.rmxsantiago.data.robots.MovieRobot;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@RunWith(AndroidJUnit4.class)
public class MovieDaoTest extends BaseDaoTest{
    private MovieDAO movieDAO;
    private MovieRobot movieRobot;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        movieDAO = database.getMovieDAO();
        movieRobot = new MovieRobot(movieDAO);
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        movieRobot = null;
        movieDAO = null;
    }
}
