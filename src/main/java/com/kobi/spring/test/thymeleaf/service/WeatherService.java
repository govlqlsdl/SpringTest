package com.kobi.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.test.thymeleaf.domain.Weather;
import com.kobi.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherRepository weatherRepository; //5
	
	public int addWeather(
			LocalDate date
			, String weather
			, double temperatures
			, double precipitation
			, String microdust
			, double windSpeed) { //2
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microdust, windSpeed); //6

		return count; //7
	}
	
	public int addWeatherByObject(Weather weather) { //15
		int count = weatherRepository.insertWeatherByObejct(weather);
		return count; //18
	}
	
	public List<Weather> getWeatherHistory() { //21
		List<Weather> weatherHistory = weatherRepository.selectWeatherHistory();
		return weatherHistory; //24
	}

}