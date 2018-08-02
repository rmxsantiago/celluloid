package ie.rmxsantiago.domain.model.common;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Entity(tableName = "genre")
public class Genre {

    @ColumnInfo(name = "gnre_id")
    @PrimaryKey private int id;

    @ColumnInfo(name = "gnre_name")
    private String name;

    //region Contructors
    public Genre() {
    }

    @Ignore
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //endregion

    //region Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregions

    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
}
