package com.sbs.weather.app.model;

import lombok.Data;

@Data
public class Coord{
	 public double lat;
	 public double lon;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public Coord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coord(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}
	}