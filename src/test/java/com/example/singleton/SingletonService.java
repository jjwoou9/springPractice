package com.example.singleton;

public class SingletonService {
	
	//1. static ������ ��ü�� �� 1���� �����صд�.
	 private static final SingletonService instance = new SingletonService();
	 
	 //2. public���� ��� ��ü �ν��ͽ��� �ʿ��ϸ� �� static �޼��带 ���ؼ��� ��ȸ�ϵ�������Ѵ�.
	 public static SingletonService getInstance() {
		 return instance;
	 }
	 //3. �����ڸ� private���� �����ؼ� �ܺο��� new Ű���带 ����� ��ü ������ ���ϰ� ���´�.
	 private SingletonService() {
		 
	 }
	 
	 public void logic() {
		 System.out.println("�̱��� ��ü ���� ȣ��");
	 }
}
