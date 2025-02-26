package com.kobi.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kobi.spring.test.mvc.domain.Realtor;
import com.kobi.spring.test.mvc.repository.RealtorRepository;

@Controller
public class RealtorService {
	
	@Autowired // 4-2, 10
	private RealtorRepository realtorRepository; // 4-2, 9
	
	public int addRealtor(Realtor realtor) { // 4-2, 6
		int count = realtorRepository.insertRealtorByObject(realtor); // 4-2, 11
		
		return count;
	}

}