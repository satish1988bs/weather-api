package com.sbs.weather.app.model;

import lombok.Data;

@Data
public class City {
	public int id;
	public String name;
	public Coord coord;
	public String country;
	public int population;
	public int timezone;
	public int sunrise;
	public int sunset;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int id, String name, Coord coord, String country, int population, int timezone, int sunrise,
			int sunset) {
		super();
		this.id = id;
		this.name = name;
		this.coord = coord;
		this.country = country;
		this.population = population;
		this.timezone = timezone;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}


	public City(String city) {
		this.name=city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public int getSunrise() {
		return sunrise;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public int getSunset() {
		return sunset;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}
}