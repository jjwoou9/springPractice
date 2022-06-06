package com.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("Ÿ������ ��ȸ�� ���� Ÿ���� �� �̻��̸�, �ߺ� ������ �߻��Ѵ�.")
	void findBeanByTypeDuplicate() {
		MemberRepository bean = ac.getBean(MemberRepository.class);
		assertThrows(NoUniqueBeanDefinitionException.class, 
				() -> ac.getBean(MemberRepository.class));
	}
	
	@Test
	@DisplayName("Ÿ������ ��ȸ�� ���� Ÿ���� �� �̻� ������, �� �̸��� �����ϸ� �ȴ�.")
	void findBeanByName() {
		MemberRepository memberRepositroy = ac.getBean("memberRepository1" , MemberRepository.class);
		assertThat(memberRepositroy).isInstanceOf(MemberRepository.class);
	}
	
	@Test
	@DisplayName("Ư�� Ÿ���� ��� ��ȸ�ϱ�.")
	void findAllBeanByType() {
		Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
		for(String key : beansOfType.keySet()) {
			System.out.println("key = " + key + " value = " +beansOfType.get(key));
		}
		System.out.println("beansOfType = " + beansOfType);
		assertThat(beansOfType.size()).isEqualTo(2);
	
	} 
	
	
	
	
	
	@Configuration
	static class SameBeanConfig{
		
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
	}
}
