package com.kobi.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobi.spring.test.thymeleaf.domain.Weather;
import com.kobi.spring.test.thymeleaf.service.WeatherService;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {
	
	@Autowired //9
	private WeatherService weatherService; //8
	
	@ResponseBody
	@GetMapping("/create")
	public String createWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date  // 2025년 2월 24일
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed //1
			@ModelAttribute Weather weather) { //14 (한마디로 //1이 //14로 변경)
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed); //9
		int count = weatherService.addWeatherByObject(weather); //19 (한마디로 //9가 //19로 변경)
		
		return "삽입 결과 : " + count; //10
		
	}
	
	
	@GetMapping("/input")
	public String inputWeather() {
		return "thymeleaf/weather/input"; //11
	}
	
	@GetMapping("/list")
	public String weatherHistory(Model model) { //20
		List<Weather> weatherHistory = weatherService.getWeatherHistory(); //25
		
		model.addAttribute("weatherHistory", weatherHistory); //26
		return "thymeleaf/weather/list";	
	}
}