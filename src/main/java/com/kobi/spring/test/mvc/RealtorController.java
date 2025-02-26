package com.kobi.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kobi.spring.test.mvc.domain.Realtor;
import com.kobi.spring.test.mvc.service.RealtorService;

@RequestMapping("/mvc/realtor")
@Controller // 4-2, 1
public class RealtorController {
	
	@Autowired // 4-2, 13
	private RealtorService realtorService; // 4-2, 12 서비스에서 완성하고 컨트롤러에서 객체를 통해 실제 값을 저장하는 흐름 
	
//	@ResponseBody
	@GetMapping("/create") // 4-2, 3
	public String createRealtor(
			@RequestParam("office") String office
			, @RequestParam("phoneNumber") String phoneNumber
			, @RequestParam("address") String address
			, @RequestParam("grade") String grade // 4-2, 2
			, Model model) { // 4-2, 19
		
		
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade); // 4-2, 5 entity 클래스로 도메인만들고 객체를 통해서 저장할 값을 정리한다
		
		int count = realtorService.addRealtor(realtor); // 4-2, 14
		
		model.addAttribute("realtor", realtor); // 4-2, 20
		
		return "mvc/realtorInfo"; // 4-2, 21
	}
	
	@GetMapping("/input")
	public String inputRealtor() {
		return "mvc/realtorInput"; // 4-2, 16
	}

}