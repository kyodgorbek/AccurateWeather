package info.qani.myapplication.weather.ForecastDaily;

public class Response {
    private City city;
    private String cod;
    private float message;
    private int cnt;
    private DailyForecast[] list;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public DailyForecast[] getList() {
        return list;
    }

    public void setList(DailyForecast[] list) {
        this.list = list;
    }
}

