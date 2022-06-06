package com.example.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

	private String url;
	
	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	//서비스 시작시 호출
	public void connect() {
		System.out.println("connect: " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + " message = " + message);
	}
	
	//서비스 종료시 호출
	public void disConnect() {
		System.out.println("close: " + url);
	}
	
	@PostConstruct
	public void init() throws Exception { //InitializingBean override 의존관계 끝나면 주입 하겠다.
		connect();
		call("초기화 연결 메세지");
	}

	@PreDestroy
	public void close() throws Exception { //DisposableBean ovveride
		disConnect();
	}
}
