package com.sbs.weather.app.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
public class ForecastWeather {
	private Map<String, Object> map=new HashMap<>();

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public ForecastWeather(Map<String, Object> map) {
		super();
		this.map = map;
	}

	public ForecastWeather() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}