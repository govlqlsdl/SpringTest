package com.kobi.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kobi.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

	// Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회하세요.
	// WHERE `companyId` = #{}
	public List<Recruit> findByCompanyId(int companyId);
	
	// 웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
	// WHERE `position` = #{} AND `type` = #{}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// 정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	// WHERE `type` = #{} OR `salary` >= #{}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	// WHERE `type` = #{} ORDER BY `salary` DESC LIMIT 3
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	// WHERE `region` = #{} AND `salary` BETWEEN #{} AND #{}
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	
	// Native query 로 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
	@Query(value="SELECT * FROM `recruit` "
			+ "WHERE `deadline` > :deadline " // '2026-04-10'"
			+ "AND `salary` >= :salary " // 8100"
			+ "AND `type` = :type " // '정규직'"
			+ "ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectByNativeQuery(
			@Param("deadline") LocalDate deadline
			, @Param("salary") int salary
			, @Param("type") String type);
}
