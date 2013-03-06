package com.caimingqin.app.jms;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.caimingqin.app.model.Car;

public class MainTest  {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"E:\\j2eeworkplace\\app\\src\\main\\resources\\AppContext.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		MessageSender sender = (MessageSender) context.getBean("messageSender");
		sender.setJmsTemplate(jmsTemplate);
		 for (int i = 1; i < 10; i++) {
			 sender.sendMessage(new Car("120", "car"));
		Thread.sleep(1000);// 1秒后发送下一条消息
		 }
	}

	@Test
	public void test() throws InterruptedException {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"E:\\j2eeworkplace\\app\\src\\main\\resources\\AppContext.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		MessageSender sender = (MessageSender) context.getBean("messageSender");
		sender.setJmsTemplate(jmsTemplate);
		sender.sendMessage(new Car("120", "car"));
	}
}
