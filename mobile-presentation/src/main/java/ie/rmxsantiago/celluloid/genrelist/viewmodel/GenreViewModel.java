package ie.rmxsantiago.celluloid.genrelist.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import ie.rmxsantiago.domain.model.common.Genre;
import ie.rmxsantiago.domain.repositories.GenreRepository;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreViewModel extends ViewModel {
    private LiveData<List<Genre>> genres;
    private GenreRepository genreRepository;

    public GenreViewModel(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public void init(){
        genres = genreRepository.getMovieGenres();
    }

    public LiveData<List<Genre>> getGenres() {
        return this.genres;
    }
}
