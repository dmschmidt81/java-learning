
public class WeatherAppRunner {

     public static void main(String[] args)
    {
        double latLansing = 42.7325;
        double longLansing = -84.5555;

        WeatherApp weather = new WeatherApp(latLansing, longLansing);

        weather.getWeather();


    }
    
}
