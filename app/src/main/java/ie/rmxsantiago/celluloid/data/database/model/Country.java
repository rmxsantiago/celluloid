package ie.rmxsantiago.celluloid.data.database.model;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("iso_3166_1")
    private String iso31661;
    private String name;

    //region Getters/Setters

    public String getIso31661() {
        return iso31661;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion
}
