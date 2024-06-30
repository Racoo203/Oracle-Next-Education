import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyQuery {
    public void queryAPI() {
        final String clave = "c6c3c6079b0311f485af96cd";
        final String moneda = "USD";
        String url = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + moneda;

        URI direcion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direcion).build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
//            return new Gson().fromJson(response.body(), Pelicula.class);

        } catch (Exception e) {
            System.out.println("Algo");;
        }
    }
}
