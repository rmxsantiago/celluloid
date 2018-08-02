package ie.rmxsantiago.data.room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import androidx.test.runner.AndroidJUnit4;
import ie.rmxsantiago.data.database.daos.GenreDAO;
import ie.rmxsantiago.data.utils.LiveDataTestUtil;
import ie.rmxsantiago.domain.model.common.Genre;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@RunWith(AndroidJUnit4.class)
public class GenreDaoTest extends BaseDaoTest{
    private GenreDAO genreDAO;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        genreDAO = database.getGenreDAO();
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
        genreDAO = null;
    }

    @Test
    public void findGenreByExactName(){
        this.genreDAO.insert(new Genre(1, "Action"));
        Genre genre = this.genreDAO.findGenreByExactName("Action");

        assertNotNull(genre);
        assertEquals(1, genre.getId());
        assertEquals("Action", genre.getName());
    }

    @Test
    public void findGenreByName(){
        this.genreDAO.insert(new Genre(1, "Action"));
        List<Genre> genre = this.genreDAO.findGenreByName("Action");

        assertNotNull(genre);
        assertEquals(1, genre.size());
    }


    @Test
    public void insert(){
        this.genreDAO.insert(new Genre(1, "Action"));

        Genre genre = this.genreDAO.findGenreById(1);
        assertNotNull(genre);
    }

    @Test
    public void deleteAll() throws InterruptedException {
        this.genreDAO.insert(new Genre(1, "Action"));
        this.genreDAO.deleteAllGenres();

        List<Genre> allGenres = LiveDataTestUtil.getValue(genreDAO.returnAllGenders());
        assertTrue(allGenres.isEmpty());
    }
}
