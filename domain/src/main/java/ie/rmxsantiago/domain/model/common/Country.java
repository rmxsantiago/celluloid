package ie.rmxsantiago.domain.model.common;

import com.google.gson.annotations.SerializedName;

import androidx.room.Ignore;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class Country {
    @SerializedName("iso_3166_1")
    private String iso31661;
    private String name;

    //region Constructors

    public Country() {
    }

    @Ignore
    public Country(String iso31661, String name) {
        this.iso31661 = iso31661;
        this.name = name;
    }

    //endregion

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
