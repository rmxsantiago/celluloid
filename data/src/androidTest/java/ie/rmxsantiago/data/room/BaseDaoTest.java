package ie.rmxsantiago.data.room;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import ie.rmxsantiago.data.database.MoviesDatabase;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public abstract class BaseDaoTest {
    protected MoviesDatabase database;
    protected Gson gson;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        gson = new Gson();
        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                MoviesDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void tearDown() throws Exception {
        database.close();
    }
}
