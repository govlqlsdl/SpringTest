package com.kobi.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kobi.spring.test.mvc.domain.Seller;
import com.kobi.spring.test.mvc.service.SellerService;

@RequestMapping("/mvc/seller") //공통요소 잡아주기
@Controller //4-1, 1
public class SellerController {
	
	@Autowired
	private SellerService sellerService; //4-1, 13 서비스에서 addseller 완성했고 서비스에 있는 메소드를 호출하기 위해 멤버 변수로 먼저 구성해준다
	
//	@ResponseBody 어노테이션이 있으면 리턴된 값이 responseBody에 그대로 담기고 없으면 리턴된 값이 html을 찾기위한 경로로 활용된다
	@PostMapping("/create") //4-1, 3 메소드는 파라미터 상태에 따라 생각해서 작성하자
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) { //4-1, 2 이제 기능 수행이 필요하고 변수를 저장해야하기 때문에 service패키지 만들어야 한다
		
		int count = sellerService.addSeller(nickname, profileImage, temperature); //4-1, 14
		
		return "redirect:/mvc/seller/info"; //삽입결과 : + count 4-1, 15  //4-1, 33 저장 한것을 다 수행되고 나면 redirect로 재사용해라 
		
	}
	
	@GetMapping("/input") //4-1, 19 파라미터 없기때문에 get메소드 형식으로
	public String inputSeller() { //4-1, 17 경로가 리턴되도록 String
		return "mvc/sellerInput"; //4-1, 18
	}
	
	@GetMapping("/info") //4-1, 23
	public String sellerInfo(@RequestParam(value="id", required=false) Integer id //4-1, 34 기본적으로 required=true로 되어있다
			,Model model) { //4-1, 22
		// 파라미터가 전달되지 않으면 null로 되어있고 id를 int로 하면 제대로 전달이 안되기 때문에 integer id로 사용한다
		Seller seller = null; // 지역변수 if 안에서 사용해야하기때문에 변수로 만들어 준다
		if(id == null) { //id가 null이면 1번 문제대로 나오고 id가 있으면 3번문제 id의 정보로 나와진다(?id=3)
			seller = sellerService.getLastSeller(); //4-1, 31
		} else {			
			seller = sellerService.getSeller(id); //4-1, 40
		}
		
		model.addAttribute("seller", seller); //4-1, 32 키 벨류 형태로 명시한다
		// model : 자바 안에서 얻어진 객체를 html에 직접적으로 가져다 쓸 수 없으니까 model 매게체를 두고 controller에서는 그값을 채우고 html 에서는 그 값을 꺼내 쓸 수 있도록 하는 형태로 구성한다
		return "mvc/sellerInfo"; //4-1, 24
	}

}