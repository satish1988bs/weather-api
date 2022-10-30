package com.sbs.weather.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class Rain{
	 @JsonProperty("3h") 
	 public double _3h;
	}