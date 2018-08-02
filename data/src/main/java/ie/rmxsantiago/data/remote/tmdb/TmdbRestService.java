package ie.rmxsantiago.data.remote.tmdb;

import ie.rmxsantiago.domain.model.reponses.GenreResponse;
import ie.rmxsantiago.domain.model.reponses.MoviesByGenreResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * This is an interface which represents the TMDB Rest API
 * <a href="https://www.themoviedb.org/">https://www.themoviedb.org/</a>
 *
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public interface TmdbRestService {
    @GET("genre/movie/list")
    Call<GenreResponse> listGenre(@Query("api_key") String api, @Query("language") String lang);

    @GET("/genre/{genre_id}/movies")
    Call<MoviesByGenreResponse> listMoviesByGenre(@Path("genre_id") int genreId, @Query("api_key") String api, @Query("language") String lang);
}
