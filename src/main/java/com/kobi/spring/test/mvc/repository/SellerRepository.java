package com.kobi.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kobi.spring.test.mvc.domain.Seller;

@Mapper //4-1, 6
public interface SellerRepository {
	
	public int insertSeller(@Param("nickname") String nickname
			//insert 하는 과정에서 결과보다는 실행된 행위 개수 이기 때문에 int로 고정되어 있다
			, @Param("profileImage") String profileImage
			, @Param("temperature") double temperature); //4-1, 7 파라미터는 xml에서 커리를 완성시키는데 사용되는 값으로 활용되야 한다.
	
	public Seller selectLastSeller(); //4-1, 26 entity 클래스를 활용하면 될것같다 -> 도메인만들어서 만든다
	
	public Seller selectSeller(@Param("id") int id); //4-1, 36

}