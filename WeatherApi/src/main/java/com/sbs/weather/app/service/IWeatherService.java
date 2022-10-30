package com.sbs.weather.app.service;

import com.sbs.weather.app.model.CityWeather;

public interface IWeatherService<T>{

	CityWeather getForecast(int forcastDaysCount, String city);

}