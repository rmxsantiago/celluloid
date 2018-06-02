package ie.rmxsantiago.celluloid.data.database.daos;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import ie.rmxsantiago.celluloid.data.database.model.Genre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Dao
public interface GenreDAO {
    @Query("select * from genre where gnre_id = :id")
    Genre findGenreById(int id);

    @Query("select * from genre where gnre_name like :name")
    List<Genre> findGenreByName(String name);

    @Query("select * from genre")
    LiveData<List<Genre>> returnAllGenders();


    @Insert
    void insertGenre(Genre genre);

    @Insert
    void insertGenres(List<Genre> genres);

    @Query("delete from genre")
    void deleteGenres();

    @Update
    void updateGenre(Genre genre);
}
