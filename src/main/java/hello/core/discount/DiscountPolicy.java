package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

		/**
		 * 
		 * @return ���� ��� �ݾ�
		 */
	int discount(Member member, int price);
	
	
	
	
}
