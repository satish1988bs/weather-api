package com.sbs.weather.app.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"temp",
"temp_min",
"temp_max",
"pressure",
"sea_level",
"grnd_level",
"humidity",
"temp_kf"
})
@Data
public class Main{
	 public double temp;
	 public double feels_like;
	 public double temp_min;
	 public double temp_max;
	 public int pressure;
	 public int sea_level;
	 public int grnd_level;
	 public int humidity;
	 public double temp_kf;
	 private String warning;
	 @JsonIgnore
	 private Map<String, Object> extraProperties = new HashMap<String, Object>();
	public Main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int sea_level,
			int grnd_level, int humidity, double temp_kf) {
		super();
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.sea_level = sea_level;
		this.grnd_level = grnd_level;
		this.humidity = humidity;
		this.temp_kf = temp_kf;
	}
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getFeels_like() {
		return feels_like;
	}
	public void setFeels_like(double feels_like) {
		this.feels_like = feels_like;
	}
	public double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}
	public double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getSea_level() {
		return sea_level;
	}
	public void setSea_level(int sea_level) {
		this.sea_level = sea_level;
	}
	public int getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(int grnd_level) {
		this.grnd_level = grnd_level;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public double getTemp_kf() {
		return temp_kf;
	}
	public void setTemp_kf(double temp_kf) {
		this.temp_kf = temp_kf;
	}
	public Map<String, Object> getExtraProperties() {
		return extraProperties;
	}
	public void setExtraProperties(Map<String, Object> extraProperties) {
		this.extraProperties = extraProperties;
	}
	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}
	}