package com.smhrd.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // db 테이블 처럼 쓰겠다
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
	// 스프링부트에서 카멜기법으로 작성시 데이터베이스에서는 스네이크 기법으로 자동인식하여 작성됨!!
	// 그래서 스프링코드안에서는 꼭 카멜기법으로 작성해야 함!!
	// 필드들은 --> DB의 컬럼이 될 예정
	// ★★★필수 조건★★★ 반드시 pk가 존재해야 한다
	// --> 숫자(long)으로 지정
	
	@Id // pk 지정 --> 자동으로 숫자 증가
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increase
	private Long id;
	
	// 컬럼 설정 하는 법 -- unique, not null, length
	// @Column
	
	@Column(unique = true, nullable = false) // unique 설정 + not null 설정
	private String userId;
	
	// 길이 조정
	@Column(length = 100)
	private String pw;
	
	private String name;
	private int age;
}
