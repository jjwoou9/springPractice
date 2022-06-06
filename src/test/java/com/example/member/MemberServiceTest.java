package com.example.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberServiceTest {

	AppConfig appConfig = new AppConfig();
	MemberService memberService = appConfig.memberService();
	@Test
	void join() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		//when
		memberService.join(member);
		Member findMember = memberService.findMember(1L); 
		
		//then
		Assertions.assertThat(member).isEqualTo(findMember);
		
		
	}
}
