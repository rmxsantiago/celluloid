package ie.rmxsantiago.domain.model.common;

import androidx.room.Entity;
import androidx.room.Ignore;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@Entity(tableName = "movie_genre",
        primaryKeys = {"mvgn_genre", "mvgn_movie"})
public class MovieGenre {
    private int mvgn_genre;
    private int mvgn_movie;

    //region Constructor
    public MovieGenre() {
    }

    @Ignore
    public MovieGenre(int mvgn_movie, int mvgn_genre) {
        this.mvgn_movie = mvgn_movie;
        this.mvgn_genre = mvgn_genre;
    }

    //endregion

    //region Getters/Setters

    public int getMvgn_genre() {
        return mvgn_genre;
    }

    public void setMvgn_genre(int mvgn_genre) {
        this.mvgn_genre = mvgn_genre;
    }

    public int getMvgn_movie() {
        return mvgn_movie;
    }

    public void setMvgn_movie(int mvgn_movie) {
        this.mvgn_movie = mvgn_movie;
    }


    //endregion

}
