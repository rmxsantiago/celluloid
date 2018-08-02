package ie.rmxsantiago.data.database.daos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Dao
abstract class BaseDAO<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(T entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(List<T> listOfEntities);

    @Update
    public abstract void update(T entitiy);

}
