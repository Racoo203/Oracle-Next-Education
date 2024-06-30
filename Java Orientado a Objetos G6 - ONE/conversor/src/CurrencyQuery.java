import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyQuery {
    public Calculator queryAPI(String fromCurrency) {
        final String clave = "c6c3c6079b0311f485af96cd";
        String url = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + fromCurrency;

        try {

            URI direccion = URI.create(url);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Calculator.class);

        } catch (Exception e) {
            throw new RuntimeException("Datos no encontrados");
        }

    }
}
