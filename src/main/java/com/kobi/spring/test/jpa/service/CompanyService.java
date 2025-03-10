package com.kobi.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kobi.spring.test.jpa.domain.Company;
import com.kobi.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company addCompany(
			String name
			, String business
			, String scale
			, int headcount) {
		
		Company company = Company.builder()
		.name(name)
		.business(business)
		.scale(scale)
		.headcount(headcount)
		.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	
	public Company updateCompany(int id, String scale, int headcount) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		if(optionalCompany.isPresent()) { // null 인지 아닌지 알려준다 null 이 아니면(true) 실행된다
			Company company = optionalCompany.get();
			
			company = company.toBuilder().scale(scale).headcount(headcount).build();
			
			Company result = companyRepository.save(company);
			
			return result;
		}
		
		
		return null;
		
	}
	
	public void deleteCompany(int id) {
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
//		if(optionalCompany.isPresent()) {
//			Company company = optionalCompany.get();
//			companyRepository.delete(company);
//		}
		
		// 람다식 표현 
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
	}

}