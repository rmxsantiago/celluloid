package ie.rmxsantiago.celluloid.genrelist.viewmodel;

import androidx.lifecycle.ViewModelProvider;
import ie.rmxsantiago.domain.repositories.GenreRepository;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreViewModelFactory implements ViewModelProvider.Factory {
    private final GenreRepository genreRepository;

    public GenreViewModelFactory(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public GenreViewModel create(Class modelClass) {
        return new GenreViewModel(genreRepository);
    }
}
