package com.sbs.weather.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

import com.sbs.weather.app.props.GlobalProperties;
@EnableCaching
@SpringBootApplication
@ConfigurationProperties
public class WeatherServiceApplication implements CommandLineRunner {
	@Autowired
	private GlobalProperties globalProperties;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WeatherServiceApplication.class);
		app.setLazyInitialization(true);
		app.run(args);
//		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(globalProperties);
	}

}
