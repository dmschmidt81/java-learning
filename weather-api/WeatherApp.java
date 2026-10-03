import java.net.http.HttpClient;//sends the request
import java.net.http.HttpRequest;//represents the request
import java.net.http.HttpResponse;//represents the response
import java.net.URI;//destination
import java.io.IOException;//possible network/file/IO error
//gson=toolbox Json=dataFormat Object=Tools
//             toolbox.languageTools
//import com.google.gson.JsonObject;//Json as Object
//import com.google.gson.JsonParser;//Parses Json text

public class WeatherApp {


    //variables
    private HttpClient client;
    private double latitude;
    private double longitude;
    private double temperature;


    public WeatherApp(double lat, double longi)
    {
        latitude = lat;
        longitude = longi;
        client = HttpClient.newHttpClient();

    }

    public void getWeather()
    {
        String url = "https://api.open-meteo.com/v1/forecast"+"?latitude="+latitude+"&longitude="+longitude +"&current=temperature_2m";
        URI site = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
        .uri(site)
        .build();
     
        try
        {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        }
        catch(IOException e)
        {
            System.out.println("Network problem "+e.getMessage());
        }
        catch(InterruptedException e)
        {
            System.out.println("Request was interrupted "+e.getMessage());
        }

    }   
}
