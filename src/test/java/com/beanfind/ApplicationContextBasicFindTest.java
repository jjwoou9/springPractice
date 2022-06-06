package com.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberServie", MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("빈 이름없이 타입으로만 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByName2() {
		MemberService memberService = ac.getBean("memberServie", MemberServiceImpl.class); //구현에 의존된 코드
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	@Test
	@DisplayName("빈 이름으로 조회X")
	void findBeanByNameX() {
//		 ac.getBean("xxxxx", MemberService.class);
//		MemberService memberService = ac.getBean("xxxxx", MemberService.class);
		assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("xxxxx", MemberService.class));
	}
	
}
