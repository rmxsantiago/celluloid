package ie.rmxsantiago.data.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.test.InstrumentationRegistry;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * @author Rafael Santiago (@rmxsantiago)
 * @version 0.1
 */
public class WebServiceHelper {

    public static String fromInputStreamToString(String fileName) throws IOException {
        InputStream inputStream = InstrumentationRegistry.getContext().getAssets().open(fileName);

        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line);
        }
        return total.toString();
    }

    public static void createServerResponse(MockWebServer server, String body, int responseCode){
        MockResponse response = new MockResponse();
        response.setResponseCode(responseCode);
        response.setBody(body);

        server.enqueue(response);
    }
}
