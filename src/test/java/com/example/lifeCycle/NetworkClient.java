package com.example.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

	private String url;
	
	public NetworkClient() {
		System.out.println("������ ȣ��, url = " + url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	//���� ���۽� ȣ��
	public void connect() {
		System.out.println("connect: " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + " message = " + message);
	}
	
	//���� ����� ȣ��
	public void disConnect() {
		System.out.println("close: " + url);
	}
	
	@PostConstruct
	public void init() throws Exception { //InitializingBean override �������� ������ ���� �ϰڴ�.
		connect();
		call("�ʱ�ȭ ���� �޼���");
	}

	@PreDestroy
	public void close() throws Exception { //DisposableBean ovveride
		disConnect();
	}
}
