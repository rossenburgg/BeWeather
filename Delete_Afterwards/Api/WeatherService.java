package com.bsu.beweather.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherService {
    private static final String BASE_URL = "https://api.weatherapi.com";
    private Retrofit retrofit;

    public WeatherService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public WeatherAPI getWeatherAPI() {
        return retrofit.create(WeatherAPI.class);
    }
}
