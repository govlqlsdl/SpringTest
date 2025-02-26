package com.kobi.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kobi.spring.test.mybatis.domain.RealEstate;

@Mapper //3-1-1, 6 인터페이스
public interface RealEstateRepository {
	
	// real_estate 테이블에서 id가 일치하는 행 조회 
	public RealEstate selectRealEstate(@Param("id") int id); //3-1-1, 7 자바문법이 아니기때문에 param키워드 사용,
	//3-1-1, 9 RealEstate만듬											//entity클래스로 구성 : 대상이 되는 테이블에 컬럼명과 정확히 일치하는 멤버변수를 가진 클래스, 그걸 통해서 컬럼이름 값을 멤버변수에 하나하나 저장하는 객체로 한행의 정보를 지정하자
	
	// real_estate 테이블에서 전달받은 월세 보다 낮은 행 조회
	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rentPrice") int rentPrice);
	
	// real_estate 테이블에서 전달 받은 면적 보다 넓고, 가격보다 낮은 매매 매물 행 조회
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area
			, @Param("price") int price);
	
	public int insertRealEstateByObject(RealEstate realEstate); //3-2-1, 3
	
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice); //3-2-2, 3
	
//	id가 22 인 행의 type 을 전세로 바꾸고 가격을 70000으로 변경하세요.
	public int updateRealEstate(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price); //3-3, 4
	
	public int deleteRealEstate(@Param("id") int id); //3-4, 3

}