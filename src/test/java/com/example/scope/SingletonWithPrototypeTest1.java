package com.example.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import com.example.scope.PrototypeTest.PrototypeBean;

public class SingletonWithPrototypeTest1 {
	
	@Test
	 void prototypeFind() {
		 AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		 PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		 prototypeBean1.addCount();
		 assertThat(prototypeBean1.getCount()).isEqualTo(1);
		 PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		 prototypeBean2.addCount();
		 assertThat(prototypeBean2.getCount()).isEqualTo(1);
	 }
	
	@Test
	 void singletonClientUsePrototype() {
		 AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
		 ClientBean clientBean1 = ac.getBean(ClientBean.class);
		 int count1 = clientBean1.logic();
		 assertThat(count1).isEqualTo(1);
		 System.out.println("count1 = " + count1);
		 System.out.println("clientBean1 = " + clientBean1);
		 ClientBean clientBean2 = ac.getBean(ClientBean.class);
		 int count2 = clientBean2.logic();
		 System.out.println("count2 = " + count2);
		 System.out.println("clientBean2 = " + clientBean2);
		 assertThat(count2).isEqualTo(1);
	 }
	
	 static class ClientBean {
		@Autowired
//		private ObjectProvider<PrototypeBean> prototypeBeanProvider;
		private Provider<PrototypeBean> provider;
		
		 public int logic() {
//			 PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
			 PrototypeBean prototypeBean = provider.get();
			 prototypeBean.addCount();
			 int count = prototypeBean.getCount();
			 return count;
		 }
	 }
	
	@Scope("prototype")
	 static class PrototypeBean {
		private int count = 0;
		
		public void addCount() {
			count++;
		}
		
		public int getCount() {
			return count;
		}
		
		@PostConstruct
		public void init() {
			System.out.println("PrototypeBean.init " + this);
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("PrototypeBean.destroy");
		}
	}
}
