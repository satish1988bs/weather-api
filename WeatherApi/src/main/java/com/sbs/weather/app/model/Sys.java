package com.sbs.weather.app.model;

import lombok.Data;

@Data
public class Sys{
	 public String pod;

	public Sys(String pod) {
		super();
		this.pod = pod;
	}

	public Sys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPod() {
		return pod;
	}

	public void setPod(String pod) {
		this.pod = pod;
	}
	 
	}