package ie.rmxsantiago.celluloid;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import ie.rmxsantiago.celluloid.data.database.MoviesDatabase;

@RunWith(AndroidJUnit4.class)
public class GenreDao {
    private MoviesDatabase database;

    @Before
    public void initDatabase(){
        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                MoviesDatabase.class
        ).build();
    }

    @After
    public void closeDatabase(){
        database.close();
    }
}
