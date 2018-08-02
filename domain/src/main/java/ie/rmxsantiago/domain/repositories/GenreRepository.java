package ie.rmxsantiago.domain.repositories;

import java.util.List;

import ie.rmxsantiago.domain.model.common.Genre;
import androidx.lifecycle.LiveData;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public interface GenreRepository {

    LiveData<List<Genre>> getMovieGenres();
}
