package ie.rmxsantiago.dependencyinjection;

import android.app.Application;

import ie.rmxsantiago.data.repositories.GenreRepositoryImpl;
import ie.rmxsantiago.domain.repositories.GenreRepository;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class RepositoryFactory {
    public static GenreRepository getGenreRepository(Application application){
        return new GenreRepositoryImpl(application, null);
    }
}
