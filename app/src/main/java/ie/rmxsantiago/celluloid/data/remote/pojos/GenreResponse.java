package ie.rmxsantiago.celluloid.data.remote.pojos;

import java.util.List;

import ie.rmxsantiago.celluloid.data.database.model.Genre;
/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreResponse {
    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }
}
