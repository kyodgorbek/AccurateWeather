package info.qani.myapplication.weather;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.qani.myapplication.R;

import info.qani.myapplication.weather.ForecastDaily.DailyForecast;
import info.qani.myapplication.weather.ForecastDaily.Temp;
import info.qani.myapplication.weather.ForecastDaily.Weather;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.CustomViewHolder> {
    private Context context;
    private List<DailyForecast> weathersList;
   private String city;
   private DailyForecast[] temp;
    public WeatherAdapter(Context context, List<DailyForecast> weathersList, String city) {
        this.context = context;
        this.weathersList = weathersList;
        this.city = city;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        DailyForecast dailyForecast = weathersList.get(position);

        // shu yerni tushunmayapsiz menimcha !!!
        Weather[] weathers = dailyForecast.getWeather();
        Weather weather = weathers[0];
        String icon = weather.getIcon();
        String description = weather.getDescription();
//        int r = 0;
//             if ("01d".equals(icon)) r = R.drawable.w01d;
//        else if ("01n".equals(icon)) r = R.drawable.w01n;
//        else if ("02d".equals(icon)) r = R.drawable.w02d;
//        else if ("02n".equals(icon)) r = R.drawable.w02n;
//        else if ("03d".equals(icon)) r = R.drawable.w03d;
//        else if ("03n".equals(icon)) r = R.drawable.w03n;
//        else if ("04d".equals(icon)) r = R.drawable.w04d;
//        else if ("04n".equals(icon)) r = R.drawable.w04n;
//        else if ("09d".equals(icon)) r = R.drawable.w09d;
//        else if ("09n".equals(icon)) r = R.drawable.w09n;
//        else if ("10d".equals(icon)) r = R.drawable.w10d;
//        else if ("10n".equals(icon)) r = R.drawable.w10n;
//        else if ("11d".equals(icon)) r = R.drawable.w11d;
//        else if ("11n".equals(icon)) r = R.drawable.w11n;
//        else if ("13d".equals(icon)) r = R.drawable.w13d;
//        else if ("13n".equals(icon)) r = R.drawable.w13n;
//        else if ("50d".equals(icon)) r = R.drawable.w50d;
//        else if ("50n".equals(icon)) r = R.drawable.w50n;

        Map<String, Integer> map = new HashMap<>();
        map.put("01d", R.drawable.w01d);
        map.put("01n", R.drawable.w01n);
        map.put("02d", R.drawable.w02d);
        map.put("02n", R.drawable.w02n);
        map.put("03d", R.drawable.w03d);
        map.put("03n", R.drawable.w03n);
        map.put("04d", R.drawable.w04d);
        map.put("04n", R.drawable.w04n);
        map.put("09d", R.drawable.w09d);
        map.put("09n", R.drawable.w09n);
        map.put("10d", R.drawable.w10d);
        map.put("10n", R.drawable.w10n);
        map.put("11d", R.drawable.w11d);
        map.put("11n", R.drawable.w11n);
        map.put("13d", R.drawable.w13d);
        map.put("13n", R.drawable.w13n);
        map.put("50d", R.drawable.w50d);
        map.put("50n", R.drawable.w50n);
            int r = map.get(icon);


            Drawable drawable = ContextCompat.getDrawable(context, r);
            holder.cityName.setText(city);
            holder.weatherId.setText(icon);
            holder.weatherIcon.setImageDrawable(drawable);
            holder.weatherDescription.setText(description);


    }

    @Override
    public int getItemCount() {
        return weathersList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public TextView cityName, weatherId, weatherDescription, tempName;
        public ImageView weatherIcon;

        public CustomViewHolder(View view) {
            super(view);
            cityName = view.findViewById(R.id.cityName);
            weatherId = view.findViewById(R.id.weatherId);
            weatherDescription = view.findViewById(R.id.weatherDescription);
            weatherIcon = view.findViewById(R.id.weatherIcon);
            


        }
    }
}
