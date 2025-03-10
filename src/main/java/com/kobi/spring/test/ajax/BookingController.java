package com.kobi.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobi.spring.test.ajax.domain.Booking;
import com.kobi.spring.test.ajax.service.BookingService;

@RequestMapping("/ajax/booking")
@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService; // 10
	
	@GetMapping("/list")
	public String bookingList(Model model) { // 1, 해당하는 model 객체를 통해 model 값을 채우면 html 에서 그 값을 꺼내쓴다
		
		List<Booking> bookingList = bookingService.getBookingList(); // 11
		
		model.addAttribute("bookingList", bookingList); // 12, 세팅할 객체는 키 값을 통해 대응시켜주고 조회해올 실체 객체를 두번째인자로 전달
		
		return "ajax/booking/list";
	}
	
	@GetMapping("/input")
	public String inputBooking() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/main")
	public String main() {
		return "ajax/booking/main";
	}
	
	@ResponseBody // 22, json형태로 리턴하기위함
	@GetMapping("/create")
	public Map<String, String> createBooking( // 14, API 저장하는 기능
			@RequestParam("name") String name
			, @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date   // 2025년 2월 28일
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber); // 20, 저장한 이후에 잘 저장이 되었는지 확인하기
		
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"} 이 형태로
		Map<String, String> resultMap = new HashMap<>(); // 21
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap; // 23
	}
	
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id") int id) { // 27, 삭제 API
		
		int count = bookingService.deleteBooking(id); // 32
		
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>(); // 33
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@ResponseBody
	@GetMapping("/info")
	public Map<String, Object> bookingInfo( // 36, 예약정보 API
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		Booking booking = bookingService.getBooking(name, phoneNumber); // 41
		
		// 조회 성공 {"result":"success", "data":{"name":"장나라", "day":3, "headcount":10 .... }여긴 booking안에 있는값들}
		// 조회 실패 {"result":"fail"}
		Map<String, Object> resultMap = new HashMap<>();
		if(booking != null) {
			// 성공
			resultMap.put("result", "success");
			resultMap.put("data", booking); // booking값의 형태를 넣어준다
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	
	
	
	
	
	

}
