package ie.rmxsantiago.data.database.daos;

import java.util.List;

import androidx.lifecycle.LiveData;
import ie.rmxsantiago.domain.model.common.MovieGenre;


/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
//@Dao
public abstract class MovieGenreDAO extends BaseDAO<MovieGenre>{
    private static final
    String MOVIES_BY_GENRE_QUERY = "select * " +
            "from movie inner join movie_genre on movi_id = mvgn_movie " +
            "where mvgn_genre = :genre_id";

    //@Query(MOVIES_BY_GENRE_QUERY)
    public abstract LiveData<List<MovieGenre>> findMoviesBySpecificGenre(int genre_id);
}
