package com.kobi.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kobi.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> { //<Company, long> long 으로 사용 많이 하긴 한다

}