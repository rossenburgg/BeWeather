package com.bsu.beweather.Api;

import com.bsu.beweather.Models.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("/weather")
    Call<WeatherResponse> getWeather(
            @Query("q") String location,
            @Query("appid") String apiKey
    );
}
