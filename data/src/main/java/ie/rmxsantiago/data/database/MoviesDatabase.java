package ie.rmxsantiago.data.database;

import android.content.Context;
import android.os.AsyncTask;

import javax.inject.Singleton;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import ie.rmxsantiago.data.database.daos.GenreDAO;
import ie.rmxsantiago.domain.model.common.Genre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Singleton
@Database(entities = {Genre.class}, version = 1)
public abstract class MoviesDatabase extends RoomDatabase {
    public static MoviesDatabase INSTANCE;

    public abstract GenreDAO getGenreDAO();
    //public abstract MovieDAO getMovieDAO();
    //public abstract MovieGenreDAO getMovieGenreDAO();

    /**
     * Sole constructor.
     */
    public MoviesDatabase() {}

    public static MoviesDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (MoviesDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MoviesDatabase.class,
                            "moviesdb")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private final GenreDAO mDao;

        PopulateDbAsyncTask(MoviesDatabase db) {
            mDao = db.getGenreDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            //mDao.deleteAllGenres();
            return null;
        }
    }

}
