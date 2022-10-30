package com.sbs.weather.app.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties // no prefix, root level.
public class GlobalProperties {

    private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "GlobalProperties [email=" + email + "]";
	}

    //... getters and setters, toString()
	
    
}