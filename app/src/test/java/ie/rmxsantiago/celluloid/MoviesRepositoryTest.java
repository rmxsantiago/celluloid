package ie.rmxsantiago.celluloid;

import ie.rmxsantiago.celluloid.data.source.GenreRepository;
import ie.rmxsantiago.celluloid.data.database.GenreDAO;

public class MoviesRepositoryTest {
    private GenreDAO genreDAO;
    private GenreRepository repository = new GenreRepository(genreDAO);

}
