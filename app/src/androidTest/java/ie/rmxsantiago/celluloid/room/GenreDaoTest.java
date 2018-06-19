package ie.rmxsantiago.celluloid.room;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import ie.rmxsantiago.celluloid.utils.LiveDataTestUtil;
import ie.rmxsantiago.celluloid.data.database.MoviesDatabase;
import ie.rmxsantiago.celluloid.data.database.daos.GenreDAO;
import ie.rmxsantiago.celluloid.data.database.model.Genre;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class GenreDaoTest {
    private MoviesDatabase database;
    private GenreDAO genreDAO;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDatabase(){
        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                MoviesDatabase.class)
                .allowMainThreadQueries()
                .build();

        genreDAO = database.genreDAO();
    }

    @After
    public void closeDatabase(){
        database.close();
    }


    @Test
    public void findGenreByExactName(){
        this.genreDAO.insertGenre(new Genre(1, "Action"));
        Genre genre = this.genreDAO.findGenreByExactName("Action");

        assertNotNull(genre);
        assertEquals(1, genre.getId());
        assertEquals("Action", genre.getName());
    }

    @Test
    public void findGenreByName(){
        this.genreDAO.insertGenre(new Genre(1, "Action"));
        List<Genre> genre = this.genreDAO.findGenreByName("Action");

        assertNotNull(genre);
        assertTrue(genre.size() == 1);
    }


    @Test
    public void insert(){
        this.genreDAO.insertGenre(new Genre(1, "Action"));

        Genre genre = this.genreDAO.findGenreById(1);
        assertNotNull(genre);
    }

    @Test
    public void deleteAll() throws InterruptedException {
        this.genreDAO.insertGenre(new Genre(1, "Action"));
        this.genreDAO.deleteAllGenres();

        List<Genre> allGenres = LiveDataTestUtil.getValue(genreDAO.returnAllGenders());
        assertTrue(allGenres.isEmpty());
    }
}
