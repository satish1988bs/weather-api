package com.sbs.weather.app.model;

import lombok.Data;

@Data
public class Wind {
	public double speed;
	public int deg;
	public double gust;
	private String warning;

	public Wind(double speed, int deg, double gust) {
		super();
		this.speed = speed;
		this.deg = deg;
		this.gust = gust;
	}

	public Wind() {
		super();
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	public double getGust() {
		return gust;
	}

	public void setGust(double gust) {
		this.gust = gust;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

}