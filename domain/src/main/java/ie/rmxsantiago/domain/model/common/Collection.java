package ie.rmxsantiago.domain.model.common;

import com.google.gson.annotations.SerializedName;

import androidx.room.Ignore;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class Collection {
    private int id;
    private String name;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    //region Constructors

    public Collection() {
    }

    @Ignore
    public Collection(int id, String name, String posterPath, String backdropPath) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    //endregion

    //region Getters/Setter

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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    //endregion
}
