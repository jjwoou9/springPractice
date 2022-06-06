package com.example.xml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import hello.core.member.MemberService;

public class XmlAppContext {

	@Test
	void xmlAPpContext() {
		ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
	}
}
	