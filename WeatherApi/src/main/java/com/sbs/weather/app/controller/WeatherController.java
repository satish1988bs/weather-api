package com.sbs.weather.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sbs.weather.app.exceptions.WeatherAppException;
import com.sbs.weather.app.model.CityWeather;
import com.sbs.weather.app.model.ForecastWeather;
import com.sbs.weather.app.model.WeatherData;
import com.sbs.weather.app.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {
	private static final Logger logger=LoggerFactory.getLogger(WeatherController.class);
	@Autowired
	private WeatherService weatherService;
	 
	@GetMapping(value ="weatherdata/{forcastDaysCount}/{city}/{isOffline}")
	public CityWeather fetchWeatherData(@PathVariable int forcastDaysCount,@PathVariable String city,@PathVariable  boolean isOffline) throws Exception {
		return this.weatherService.getWeatherForcast(forcastDaysCount,city,isOffline);
	}
	
	@GetMapping(value ="forecast/{forcastDaysCount}/{city}/{isOffline}")
	public ForecastWeather getWeatherForecastFor(@PathVariable int forcastDaysCount,@PathVariable String city,@PathVariable boolean isOffline) throws Exception {
		return this.weatherService.getWeatherForcastWarning(forcastDaysCount,city,isOffline);
	}

    @ExceptionHandler(value = { Exception.class,WeatherAppException.class})
    public String handleException(Exception e){
    	logger.error("Error in processing Weather app request", e);
        return "Internal server error. Please contact Weather API administrator";
    }
	
	
}
