package ie.rmxsantiago.data.network;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Arrays;

import androidx.test.runner.AndroidJUnit4;
import ie.rmxsantiago.data.remote.tmdb.TmdbRestService;
import ie.rmxsantiago.data.utils.WebServiceHelper;
import ie.rmxsantiago.domain.model.reponses.GenreResponse;
import ie.rmxsantiago.domain.model.reponses.MoviesByGenreResponse;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertNotNull;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
@RunWith(AndroidJUnit4.class)
public class TMDBWebServiceTest {
    private static final String TAG = "TMDBWebServiceTest";
    private TmdbRestService tmdbRestService;
    private MockWebServer tmdbWebServer;
    private static String API_KEY = "3661f054fd66a3f8a97df3940ff9e3b0";
    private static String LANGUAGE = "en-US";

    @Before
    public void before() throws IOException {
        tmdbWebServer = new MockWebServer();
        tmdbWebServer.start();

        HttpUrl BASE_URL = tmdbWebServer.url("/");

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionSpecs(Arrays.asList(ConnectionSpec.CLEARTEXT))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                //.client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tmdbRestService = retrofit.create(TmdbRestService.class);
    }

    @After
    public void after() throws IOException {
        tmdbWebServer.shutdown();
    }

    //region Genre

    @Test
    public void genreResponseNotNull() throws IOException {
        String json = WebServiceHelper.fromInputStreamToString("json/genre/genre_getMovieList.json");
        WebServiceHelper.createServerResponse(tmdbWebServer, json, 200);

        Response<GenreResponse> response = tmdbRestService.listGenre(API_KEY, LANGUAGE).execute();
        assertNotNull(response);
    }



    @Test
    public void moviesByGenreResponseNotNull() throws IOException {
        String json = WebServiceHelper.fromInputStreamToString("json/genre/genre_getMovies.json");
        WebServiceHelper.createServerResponse(tmdbWebServer, json, 200);

        Response<MoviesByGenreResponse> response = tmdbRestService.listMoviesByGenre(28,API_KEY, LANGUAGE).execute();
        assertNotNull(response);
    }

    //endregion

    //region Movies


    //endregion
}
