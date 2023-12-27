package com.bsu.beweather.Models;

import com.google.gson.annotations.SerializedName;

public class WeatherResponse {
    @SerializedName("temperature")
    private double temperature;

    @SerializedName("description")
    private String description;


}
