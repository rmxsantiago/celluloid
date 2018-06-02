package ie.rmxsantiago.celluloid.presentation.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import ie.rmxsantiago.celluloid.data.database.model.Genre;
import ie.rmxsantiago.celluloid.data.repositories.GenreRepository;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class GenreViewModel extends AndroidViewModel {
    private LiveData<List<Genre>> genres;
    private GenreRepository genreRepository;

    public GenreViewModel(Application application) {
        super(application);
        this.genreRepository = new GenreRepository(application);
    }

    public void init(){
        genres = genreRepository.getMovieGenres();
    }

    public LiveData<List<Genre>> getGenres() {
        return this.genres;
    }
}
