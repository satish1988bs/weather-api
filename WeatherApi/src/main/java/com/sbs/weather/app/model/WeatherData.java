package com.sbs.weather.app.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
@JsonRootName("List")
@Data
public class WeatherData{
	 public int dt;
	 public Main main;
	 public ArrayList<Weather> weather;
	 public Clouds clouds;
	 public Wind wind;
	 public int visibility;
	 public double pop;
	 public Rain rain;
	 public Sys sys;
	 public String dt_txt;
	 
	 
	public WeatherData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WeatherData(int dt, Main main, ArrayList<Weather> weather, Clouds clouds, Wind wind, int visibility, double pop,
			Rain rain, Sys sys, String dt_txt) {
		super();
		this.dt = dt;
		this.main = main;
		this.weather = weather;
		this.clouds = clouds;
		this.wind = wind;
		this.visibility = visibility;
		this.pop = pop;
		this.rain = rain;
		this.sys = sys;
		this.dt_txt = dt_txt;
	}
	public int getDt() {
		return dt;
	}
	public void setDt(int dt) {
		this.dt = dt;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public ArrayList<Weather> getWeather() {
		return weather;
	}
	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public double getPop() {
		return pop;
	}
	public void setPop(double pop) {
		this.pop = pop;
	}
	public Rain getRain() {
		return rain;
	}
	public void setRain(Rain rain) {
		this.rain = rain;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
	

}