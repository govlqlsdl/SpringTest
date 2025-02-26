package com.kobi.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.test.mvc.domain.Seller;
import com.kobi.spring.test.mvc.repository.SellerRepository;

@Service //4-1, 4
public class SellerService {
	
	@Autowired //4-1, 10
	private SellerRepository sellerRepository; //4-1, 9 서비스에서 다른 플랫폼에서 노출하려면 객체가 필요하고 생성자를 통해 생성해야한다
	
	public int addSeller(String nickname
			, String profileImage
			, double temperature) { //4-1, 5 테이블 값을 저장하기 위해서는 insert 쿼리를 수행해야하고 그과정은 repository를 통해서 수행해야한다
		
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature); //4-1, 11
		
		return count; //4-1, 12
	}
	
	public Seller getLastSeller() { //4-1, 25
		
		Seller seller = sellerRepository.selectLastSeller(); //4-1, 29
		
		return seller; //4-1, 30
	}
	
	public Seller getSeller(int id) { //4-1, 35
		Seller seller = sellerRepository.selectSeller(id); //4-1, 38
		
		return seller; //4-1, 39
	}

}