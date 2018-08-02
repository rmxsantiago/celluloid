package ie.rmxsantiago.data.robots;

import ie.rmxsantiago.data.database.daos.GenreDAO;
import ie.rmxsantiago.domain.model.common.Genre;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreRobot extends BaseRobot {
    private GenreDAO genreDAO;

    public GenreRobot(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public Genre insertGenre(){
        Genre genre = new Genre(1, "Action");
        this.genreDAO.insert(genre);

        return genre;
    }
}
