package com.example.singleton;

public class StatefulService {
	
	private int price; //���¸� �����ϴ� �ʵ�
	
	public void order(String name, int price) {
		System.out.println("name = " + name + " price = " + price);
		this.price = price; //���Ⱑ ����!
	}
	
	public int getPrice() {
		return price;
	}
}
