package ie.rmxsantiago.data.database.daos;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import ie.rmxsantiago.domain.model.common.Genre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Dao
public abstract class GenreDAO extends BaseDAO<Genre>{
    @Query("select * from genre where gnre_id = :id")
    public abstract Genre findGenreById(int id);

    @Query("select * from genre where gnre_name like :name")
    public abstract List<Genre> findGenreByName(String name);

    @Query("select * from genre where gnre_name = :name")
    public abstract Genre findGenreByExactName(String name);

    @Query("select * from genre")
    public abstract LiveData<List<Genre>> returnAllGenders();




    

    @Query("delete from genre")
    public abstract void deleteAllGenres();
}
