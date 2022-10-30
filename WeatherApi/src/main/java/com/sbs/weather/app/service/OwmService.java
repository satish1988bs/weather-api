package com.sbs.weather.app.service;


import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sbs.weather.app.factories.YamlPropertySourceFactory;
import com.sbs.weather.app.model.CityWeather;

@Service
@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:weather.yml", factory = YamlPropertySourceFactory.class)
public class OwmService implements IWeatherService<CityWeather> {
	Logger logger=LoggerFactory.getLogger(getClass());
    private UriComponentsBuilder urlbuilder;
    @Value("${weather.api.appid}")
    private String appid;
    @Value("${weather.api.mode}")
    private String mode;
    @Value("${weather.api.units}")
    private String units;
    @PostConstruct
    protected void init() {

        urlbuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/forecast")
                .queryParam("cnt", "3")
                .queryParam("mode", mode)
                .queryParam("units", units)
                .queryParam("appid", appid);
    }


    @Override
    public CityWeather getForecast(int countDays,String city) {
    	urlbuilder = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/forecast")
                .queryParam("cnt", countDays)
                .queryParam("mode", mode)
                .queryParam("units", units)
                .queryParam("appid", appid);
        String url = urlbuilder.replaceQueryParam("q", city).build().toUriString();
        logger.info("External weather data fetch url built={}",url);
        return new RestTemplate().getForObject(url, CityWeather.class);
    }
}