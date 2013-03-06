package com.caimingqin.activeMQ;

import javax.jms.Destination;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageSender extends Thread {

	public static void main(String args[]) throws Exception {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"E:\\j2eeworkplace\\app\\src\\main\\resources\\AppContext.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");
		for (int i = 1; i < 1000; i++) {
			MyMessageCreator mc = new MyMessageCreator();// 生成消息
			mc.n = i;
			jmsTemplate.send(destination, mc);
			sleep(1000);// 1秒后发送下一条消息
		}

	}
}
