package com.smhrd.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.smhrd.board.entity.BoardEntity;
import com.smhrd.board.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	BoardService boardSerivce;
	
	// 메인페이지 띄우기 기능
	// 1. 매핑할 메소드 만들기 --> boot 에선 REST API Get/Post/Delete/patch 명시를 희망
	@GetMapping("/")
	public String index(Model model) {
		// legacy 에서 return 타입을 String 으로 잡았는데
		// --> viewResolver 가 WEB/INF - views 폴더의 .jsp 를 실행하겠습니다.
		
		// 내장되어있는 설정이
		// resources - templates 폴더의 .html 을 실행하겠습니다.
		// 결론 : boot 에선 index.xml 을 실행 시키겠습니다.
		
		// 게시글 모두 출력 후 index 페이지로 전달
		List<BoardEntity> list =  boardSerivce.show();
		
		// Spring request Scope 대신 사용 --> Model객체 사용
		model.addAttribute("boardList", list);
		
		return"index";
	}
	
	// 로그인 기능
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	// 회원가입 기능
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	
	// 게시판 기능
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	

}
