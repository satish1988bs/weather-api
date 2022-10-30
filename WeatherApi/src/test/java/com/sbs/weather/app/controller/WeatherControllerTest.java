package com.sbs.weather.app.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class WeatherControllerTest {
	@Autowired
	MockMvc mockMvc;
//    private String baseUrl = "http://localhost:8090";

//    private String endpointToThrowException = "/employee/2010";
//    @Autowired
//    private TestRestTemplate testRestTemplate;
	@Test
	void testFetchWeatherData() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/forecast/10/London/false")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}

	@Test
	void testGetWeatherForecastFor() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/weatherdata/10/London/false")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
	}

    @Test
    void testHandleException() throws Exception {
//    	testRestTemplate.getForObject(baseUrl + endpointToThrowException, String.class);
    	mockMvc.perform(MockMvcRequestBuilders.get("/api/forecast/367/London/false")).andExpect(MockMvcResultMatchers.status().isBadRequest()).andReturn();
    }

}
