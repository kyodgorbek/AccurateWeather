package info.qani.myapplication.weather;

import info.qani.myapplication.weather.ForecastDaily.City;
import info.qani.myapplication.weather.ForecastDaily.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/data/2.5/forecast/daily?appid=7027e7b532ce43a6d873dea78d6f30ac" )
    Call<Response> forecastDaily(@Query("lat") float lat, @Query("lon") float lon, @Query("cnt") int cnt);


}
