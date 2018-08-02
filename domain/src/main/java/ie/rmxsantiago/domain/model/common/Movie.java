package ie.rmxsantiago.domain.model.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Entity(tableName = "movie")
public class Movie {
    @SerializedName("id")
    @ColumnInfo(name = "movi_id")
    @PrimaryKey private int id;

    @SerializedName("adult")
    @ColumnInfo(name = "movi_adult_flag")
    private boolean isAdultMovie;

    @SerializedName("backdrop_path")
    @ColumnInfo(name = "movi_backdrop_image_path")
    private String backdrop_path;

    @SerializedName("genre_ids")
    @Ignore
    private List<Integer> listOfGenreIds;

    @SerializedName("original_language")
    @ColumnInfo(name="movi_original_language")
    private String originalLanguage;

    @SerializedName("original_title")
    @ColumnInfo(name = "movi_original_title")
    private String originalTitle;

    @ColumnInfo(name = "overview")
    private String overview;

    @SerializedName("release_date")
    @ColumnInfo(name = "movi_release_date")
    private String releaseDate;

    @SerializedName("poster_path")
    @ColumnInfo(name = "movi_poster_image_path")
    private String posterPath;

    @ColumnInfo(name = "movi_popularity")
    private float popularity;

    @ColumnInfo(name = "movi_title")
    private String title;

    @ColumnInfo(name = "movi_video_flag")
    private boolean video;

    @SerializedName("vote_average")
    @ColumnInfo(name = "movi_vote_average")
    private float voteAverage;

    @SerializedName("vote_count")
    @ColumnInfo(name = "movi_vote_count")
    private int voteCount;

    //region Getters/Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdultMovie() {
        return isAdultMovie;
    }

    public void setAdultMovie(boolean adultMovie) {
        isAdultMovie = adultMovie;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Integer> getListOfGenreIds() {
        return listOfGenreIds;
    }

    public void setListOfGenreIds(List<Integer> listOfGenreIds) {
        this.listOfGenreIds = listOfGenreIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }


    //endregion

}
