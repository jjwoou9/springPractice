package com.example.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {
	
	 @Test
	 @DisplayName("������ ���� ������ DI �����̳�")
	 void pureContainer() {
		 AppConfig appConfig = new AppConfig();
		 
		 //1. ��ȸ: ȣ���� �� ���� ��ü�� ����
		 MemberService memberService1 = appConfig.memberService();
		 //2. ��ȸ: ȣ���� �� ���� ��ü�� ����
		 MemberService memberService2 = appConfig.memberService();
		 
		 //�������� �ٸ� ���� Ȯ��
		 System.out.println("memberService1 = " + memberService1);
		 System.out.println("memberService2 = " + memberService2);
		 
		 //memberService1 != memberService2
		 assertThat(memberService1).isNotSameAs(memberService2);
	 }
	 
	 @Test
	 @DisplayName("�̱��� ������ ������ ��ü ���")
	 void singletonServiceTest() {
	  //private���� �����ڸ� ���Ƶξ���. ������ ������ �߻��Ѵ�.		 
	  //new SingletonService();
		 
	  //1. ��ȸ: ȣ���� �� ���� ���� ��ü�� ��ȯ
	  SingletonService singletonService1 = SingletonService.getInstance();
	  //2. ��ȸ: ȣ���� �� ���� ���� ��ü�� ��ȯ
	  SingletonService singletonService2 = SingletonService.getInstance();
	  
	  //�������� ���� ���� Ȯ��
	  System.out.println("singletonService1 = " + singletonService1);
	  System.out.println("singletonService2 = " + singletonService2);
	  // singletonService1 == singletonService2
	  
	  assertThat(singletonService1).isSameAs(singletonService2); //isSameAs�� '=='  �Ͱ���.
	  singletonService1.logic();
	 }
	 
	 @Test
	 @DisplayName("������ �����̳ʿ� �̱���")
	 void springContainer() {
	 ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	 
		 //1. ��ȸ: ȣ���� �� ���� ���� ��ü�� ��ȯ
		 MemberService memberService1 = ac.getBean("memberService",
		 MemberService.class);
		 
		 //2. ��ȸ: ȣ���� �� ���� ���� ��ü�� ��ȯ
		 MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		 
		 //�������� ���� ���� Ȯ��
		 System.out.println("memberService1 = " + memberService1);
		 System.out.println("memberService2 = " + memberService2);
		 
		 //memberService1 == memberService2
		 assertThat(memberService1).isSameAs(memberService2);
	 }
}
