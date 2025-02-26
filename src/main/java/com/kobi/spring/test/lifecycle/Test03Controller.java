package com.kobi.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {
		
		@RequestMapping("/lifecycle/test03") // 클라이언트가 요청하기 위한 url지정
		public String thymeleafResponse() {
			// html 파일 경로
			// /src/main/resources/templetes 생략
			// .html 생략
			return "lifecycle/test03"; // response의 담을 html 경로를 리턴해주는것
		}

	}