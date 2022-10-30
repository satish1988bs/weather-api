package com.sbs.weather.app.exceptions;

public class WeatherAppException extends Exception {

	public WeatherAppException() {
		super();
	}

	public WeatherAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WeatherAppException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WeatherAppException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WeatherAppException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
