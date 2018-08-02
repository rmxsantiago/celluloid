package ie.rmxsantiago.domain.model.common;

import com.google.gson.annotations.SerializedName;

import androidx.room.Ignore;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class Language {
    @SerializedName("iso_639_1")
    private String iso6391;
    private String name;

    //region Constructor

    public Language() {
    }

    @Ignore
    public Language(String iso6391, String name) {
        this.iso6391 = iso6391;
        this.name = name;
    }

    //endregion

    //region Getters/Setters

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //endregion
}
