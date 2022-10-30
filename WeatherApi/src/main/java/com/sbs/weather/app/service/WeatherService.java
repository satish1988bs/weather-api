package com.sbs.weather.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.weather.app.cachestore.CacheManager;
import com.sbs.weather.app.constants.AppConstant;
import com.sbs.weather.app.exceptions.WeatherAppException;
import com.sbs.weather.app.model.City;
import com.sbs.weather.app.model.CityWeather;
import com.sbs.weather.app.model.ForecastWeather;
import com.sbs.weather.app.model.Weather;
import com.sbs.weather.app.model.WeatherData;
@Service
public class WeatherService implements AppConstant {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IWeatherService<CityWeather> owmService;
	
	public CityWeather getWeatherForcast(int forcastDaysCount, String city, boolean isOffline) throws Exception {
		if(isOffline) {
			return getWeatherDataFromCache(city);
		}else {
			try {
				CityWeather cityWeather = getWeatherData(forcastDaysCount, city);
				CacheManager.getInstance().put(city, cityWeather);
				Consumer<? super WeatherData> action = l->{
					l.getWeather().stream().filter(t2->t2.getMain().equalsIgnoreCase(RAINY_DAY)).forEach(w->w.setWarning(CARRY_UMBRELLA));
					l.getWeather().stream().filter(t2->t2.getMain().equalsIgnoreCase(THUNDER_STORMS_DAY)).forEach(w->w.setWarning(DONT_STEP_OUT_A_STORM_IS_BREWING));
					if(l.getWind().getSpeed()>WINDY_SPEED_THRESHOLD) {
						l.getWind().setWarning(IT_S_TOO_WINDY_WATCH_OUT);
					} 
					if(l.getMain().getTemp()>HIGH_TEMP_THRESHOLD) {
						l.getMain().setWarning(USE_SUNSCREEN_LOTION);
					}
				};
//		cityWeather.list.stream().map(WeatherData::getWind ).filter( t -> t.getSpeed()>10l).forEach(w->w.setWarning("It's too windy,watch out!"));
//		cityWeather.list.stream().map(WeatherData::getMain).filter( t -> t.getTemp()>40l).forEach(w->w.setWarning("Use sunscreen lotion"));
				cityWeather.list.stream().forEach(action);
				return cityWeather;
			}catch (Exception e) {
				logger.error("Error in  fetching external api data :{}",e);
				throw new WeatherAppException(e);
			}
		}
		
	}

	private CityWeather getWeatherDataFromCache(String city) {
		if( null==CacheManager.getInstance().get(city)) {
			CityWeather cityWeather = new CityWeather();
			cityWeather.setCity(new City(city));
			cityWeather.setWarning("No weather data available for request");
			return cityWeather;
		}else {
			logger.error("Fetching weather data from cache!");
			return (CityWeather) CacheManager.getInstance().get(city);
		}
	}
	
	public CityWeather getWeatherData(int forcastDaysCount, String city) throws Exception {
		CityWeather owmResponse = owmService.getForecast(forcastDaysCount, city);
        return owmResponse;
	}

	public ForecastWeather getWeatherForcastWarning(int forcastDaysCount, String city, boolean isOffline) throws Exception {
		CityWeather weatherForcast = getWeatherForcast(forcastDaysCount,city,isOffline);
		List<Map<String, Object>> weatherForDays=new ArrayList<>();
		if(null!=weatherForcast.getList()) {
			weatherForcast.getList().forEach(w->{
				populateData(weatherForDays, w);
			});
		}
		ForecastWeather forecastWeather=new ForecastWeather();
		forecastWeather.getMap().put("city", weatherForcast.getCity());
		forecastWeather.getMap().put("Count", weatherForcast.getCnt());
		forecastWeather.getMap().put("weather forcasted days", weatherForDays);
		if(null!=weatherForcast.getWarning()) forecastWeather.getMap().put("city weather warning", weatherForcast.getWarning());
		return forecastWeather;
	}

	private void populateData(List<Map<String, Object>> weatherForDays, WeatherData w) {
		Map<String, Object> tempMap=new HashMap<String, Object>();
		List<String> warnings=new ArrayList<>();
		tempMap.put("date", w.getDt());
		tempMap.put("date text", w.getDt_txt());
		warnings.addAll(w.getWeather().stream().filter(wt->null!=wt.getWarning()).map(Weather::getWarning).collect(Collectors.toList()));
		if (null!=w.getWind().getWarning()) warnings.add(w.getWind().getWarning());
		if(null!=w.getMain().getWarning()) warnings.add(w.getMain().getWarning());
		tempMap.put("forecast warning", warnings);
		weatherForDays.add(tempMap);
	}
	
	

}
