package ie.rmxsantiago.celluloid.data.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Entity(tableName = "genre")
public class Genre {
    @PrimaryKey
    @ColumnInfo(name = "gnre_id")
    private int id;
    @ColumnInfo(name = "gnre_name")
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
}
