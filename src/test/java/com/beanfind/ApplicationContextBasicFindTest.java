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
	@DisplayName("�� �̸����� ��ȸ")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberServie", MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("�� �̸����� Ÿ�����θ� ��ȸ")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("��ü Ÿ������ ��ȸ")
	void findBeanByName2() {
		MemberService memberService = ac.getBean("memberServie", MemberServiceImpl.class); //������ ������ �ڵ�
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}
	
	
	@Test
	@DisplayName("�� �̸����� ��ȸX")
	void findBeanByNameX() {
//		 ac.getBean("xxxxx", MemberService.class);
//		MemberService memberService = ac.getBean("xxxxx", MemberService.class);
		assertThrows(NoSuchBeanDefinitionException.class, 
				() -> ac.getBean("xxxxx", MemberService.class));
	}
	
}
