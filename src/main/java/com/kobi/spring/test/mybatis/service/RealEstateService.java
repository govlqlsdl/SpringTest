package com.kobi.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.test.mybatis.domain.RealEstate;
import com.kobi.spring.test.mybatis.repository.RealEstateRepository;

@Service //3-1-1, 4
public class RealEstateService {
	
	@Autowired //3-1-1, 12 spring이 알아서 관리 저장해주는것을 설정
	private RealEstateRepository realEstateRepository; //3-1-1, 11 realestate 메소드를 호출하기 위해서는 해당객체를 통해 호출해야 한다
	// spring이 직접 관리하는 형태로 private으로 구성
	
	// 전달 받은 id와 일치하는 매물 정보 얻어 오기 
	public RealEstate getRealEstate(int id) { //3-1-1, 5
		
		// real_estate 테이블에서 id가 일치하는 행 조회 
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		
		return realEstate; //3-1-1, 13 repository에서 얻은 정보로 그대로 리턴해도 되겠다
	}
	
//	전달받은 월세보다 낮은 매물 정보 얻어오기 
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		
		// real_estate 테이블에서 전달받은 월세 보다 낮은 행 조회 
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	// 전달 받은 면적 보다 넓고, 가격보다 낮은 매매 매물 정보 얻어오기
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		// real_estate 테이블에서 전달 받은 면적 보다 넓고, 가격보다 낮은 매매 매물 행 조회 
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
	}
	
	public int addRealEstateByObejct(RealEstate realEstate) { //3-2-1, 2
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		
		return count; //3-2-1, 5
	}
	
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) { //3-2-2, 2
		
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
		return count; //3-2-2, 5
	}
	
	public int updateRealEstate(int id, String type, int price) { //3-3, 3
//	전달 받은 id와 일치하는 매물 정보의 type과 가격을 전달 받은 값으로 수정 
		int count = realEstateRepository.updateRealEstate(id, type, price);
		
		return count; //3-3, 6
	}
	
	public int deleteRealEstate(int id) { //3-4, 2
		int count = realEstateRepository.deleteRealEstate(id);
		
		return count; //3-4, 5
	}
	

}
