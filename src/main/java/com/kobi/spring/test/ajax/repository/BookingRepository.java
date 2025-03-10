package com.kobi.spring.test.ajax.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kobi.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {
	
	public List<Booking> selectBookingList(); // 3, 조건 없이 다 조회할거니까 파라미터없이하고 entity 클래스 활용한다
	
	public int insertBooking( // 16
			@Param("name") String name
			, @Param("date") LocalDate date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state); // 18
	
	public int deleteBooking(@Param("id") int id); // 29
	
	public Booking selectBooking( // 38, entity 클래스 활용한다
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);

}
