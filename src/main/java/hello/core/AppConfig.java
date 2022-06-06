package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	/*
	 * AppConfig는 어플리케이션에 실제 동작에 필요한 '구형 객체 생성'을 한다.
	 * 
	 * AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 "생성자를 통해서 주입(연결)" 해준다.
	 */
	
	@Bean
	public MemberService memberService() {
		System.out.println("call AppConfig.memberService");
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public OrderService orderService() {
		System.out.println("call AppConfig.orderService");
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		System.out.println("call AppConfig.memberRepository");
		return new MemoryMemberRepository();
	}
	
	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}
}
