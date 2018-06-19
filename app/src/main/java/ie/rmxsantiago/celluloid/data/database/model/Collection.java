package ie.rmxsantiago.celluloid.data.database.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Collection {
    private int id;
    private String name;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    private List<CollectionPart> parts;

}
