package info.qani.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import info.qani.myapplication.weather.ApiService;
import info.qani.myapplication.weather.ForecastDaily.DailyForecast;
import info.qani.myapplication.weather.ForecastDaily.Response;
import info.qani.myapplication.weather.ForecastDaily.Temp;
import info.qani.myapplication.weather.RetroClient;
import info.qani.myapplication.weather.WeatherAdapter;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeatherAdapter weatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(eLayoutManager);

        ApiService api = RetroClient.getApiService();

        float lat = 59.32f;
        float lon = 18.06f;
        int cnt = 16;

        Call<Response> call = api.forecastDaily(lat, lon, cnt);


        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call,  retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Response forecastDaily = response.body();
                    Response cityName = response.body();
                    Response degree = response.body();

                    if (forecastDaily != null) {
                        DailyForecast[] arr = forecastDaily.getList();
                        List<DailyForecast> dailyForecastList = Arrays.asList(arr);
                        String city = cityName.getCity().getName();
                        weatherAdapter = new WeatherAdapter(MainActivity.this, dailyForecastList, city);
                        recyclerView.setAdapter(weatherAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.e("API", t.toString());
            }
        });


    }
}
