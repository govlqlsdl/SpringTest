package com.kobi.spring.test.ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.test.ajax.domain.Booking;
import com.kobi.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository; // 7
	
	public List<Booking>  getBookingList() { // 2
		List<Booking> bookingList = bookingRepository.selectBookingList(); // 8
		
		return bookingList; // 9
	}
	
	public int addBooking( // 15
			String name
			, LocalDate date
			, int day
			, int headcount
			, String phoneNumber) {
		
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, "대기중"); // 19
		
		return count;
	}
	
	public int deleteBooking(int id) { // 28
		int count = bookingRepository.deleteBooking(id); // 31
		return count;
	}
	
	public Booking getBooking(String name, String phoneNumber) { // 37
		Booking booking = bookingRepository.selectBooking(name, phoneNumber); // 40
		
		return booking;
	}
	

}