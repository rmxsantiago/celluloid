package ie.rmxsantiago.domain.model.reponses;

import java.util.List;

import ie.rmxsantiago.domain.model.common.Genre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreResponse {
    private List<Genre> genres;

    //region Getter/Setters

    public List<Genre> getGenres() {
        return genres;
    }

    //endregion
}
