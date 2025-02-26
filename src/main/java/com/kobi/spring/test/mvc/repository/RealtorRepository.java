package com.kobi.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.kobi.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	public int insertRealtorByObject(Realtor realtor); // 4-2, 7

}
