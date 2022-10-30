package com.sbs.weather.app.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

//@JsonRootName("root")
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CityWeather {
	public String cod;
	public int message;
	public int cnt;
	public ArrayList<WeatherData> list;
	public City city;
	public String warning;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public ArrayList<WeatherData> getList() {
		return list;
	}

	public void setList(ArrayList<WeatherData> list) {
		this.list = list;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

}