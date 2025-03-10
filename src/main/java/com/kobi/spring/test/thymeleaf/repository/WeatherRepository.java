package com.kobi.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kobi.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public int insertWeather(
			@Param("date") LocalDate date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microdust
			, @Param("windSpeed") double windSpeed); //3
	
	public int insertWeatherByObejct(Weather weather); //16
	
	public List<Weather> selectWeatherHistory(); //22

}
