package com.kobi.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kobi.spring.test.mybatis.domain.RealEstate;
import com.kobi.spring.test.mybatis.service.RealEstateService;

@RequestMapping("/mybatis/realestate")
@Controller //3-1-1, 1
public class RealEstateController {
	
	@Autowired //3-1-1, 15 이걸 통해 객체 관리를 맡기자
	private RealEstateService realEstateService; //3-1-1, 14 service에서 만든 getrealestate라는 메소드를 호출할거다
	
	@ResponseBody
	@RequestMapping("/select/1") //3-1-1, 2
	public RealEstate realEstate(@RequestParam("id") int id) { //3-1-1, 3
		
		// request parameter로 전달 받은 id와 일치하는 매물 정보 얻어 오기 
		RealEstate realEstate = realEstateService.getRealEstate(id);
		
		return realEstate; //3-1-1, 16 json으로 표현하려고 하니 키, 벨류 형태이기때문 그대로 리턴한다.
	}
	
	@ResponseBody
	@RequestMapping("/select/2")
	public List<RealEstate> realEstateByRentPrice(@RequestParam("rent") int rentPrice) {
		
		// request parameter로 전달받은 월세보다 낮은 매물 정보 얻어오기 
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);
		
		return realEstateList;
	}
	
	@ResponseBody
	@RequestMapping("/select/3")
	public List<RealEstate> realEstateByAreaAndPrice(
			@RequestParam("area") int area
			, @RequestParam("price") int price) {
		// request parameter로 전달 받은 면적 보다 넓고, 가격보다 낮은 매매 매물 정보 얻어오기 
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);
		
		return realEstateList;
		
	}
	
	@ResponseBody
	@RequestMapping("/insert/1")
	public String createRealEstateByObject() {
		
//		realtorId : 3
//		address : 푸르지용 리버 303동 1104호
//		area : 89
//		type : 매매
//		price : 100000
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000); //3-2-1, 1
		
		int count = realEstateService.addRealEstateByObejct(realEstate);
		
		return "입력 성공 : " + count; //3-2-1, 6
		
	}
	
	@ResponseBody
	@RequestMapping("/insert/2")
	public String createRealEstate(@RequestParam("realtorId") int realtorId) { //3-2-2, 1
//		address : 썅떼빌리버 오피스텔 814호
//		area : 45
//		type : 월세
//		price : 100000
//		rentPrice : 120
		
		int count = realEstateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;  //3-2-2, 6
	}
	
	@ResponseBody
	@RequestMapping("/update") //3-3, 2
	public String updateRealEstate() { //3-3, 1
//		id가 22 인 매물 정보의 type 을 전세로 바꾸고 가격을 70000으로 변경하세요.
		int count = realEstateService.updateRealEstate(22, "전세", 70000);
		
		return "수정 결과 : " + count; //3-3, 7
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRealEstate(@RequestParam("id") int id) { //3-4, 1
		
		int count = realEstateService.deleteRealEstate(id);
		
		return "삭제 결과 : " + count; //3-4, 6
		
	}
	
	
	

}