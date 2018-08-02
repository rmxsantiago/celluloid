package ie.rmxsantiago.domain.model.common;

import com.google.gson.annotations.SerializedName;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class Company {
    private int id;
    @SerializedName("logo_path")
    private String logoPath;
    @SerializedName("name")
    private String name;
    @SerializedName("origin_country")
    private String originCountry;

    //region Constructors
    /*public Company() {
    }

    @Ignore
    public Company(int id, String, String name, String originCountry, String logoPath) {
        this.id = id;
        this.name = name;
        this.originCountry = originCountry;
        this.logoPath = logoPath;
    }*/

    //endregion

    //region Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }


    //endregion
}
