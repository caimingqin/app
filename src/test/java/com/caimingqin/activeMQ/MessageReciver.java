package com.caimingqin.activeMQ;

import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MessageReciver{

    public static void main(String args[]) throws Exception {
    	
        ApplicationContext context = new FileSystemXmlApplicationContext("E:\\j2eeworkplace\\app\\src\\main\\resources\\AppContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
        Destination destination = (Destination) context.getBean("destination");
       
        TextMessage msg = null;
        boolean isContinue = true;//是否继续接收消息
        while (isContinue) {
            msg = (TextMessage) jmsTemplate.receive(destination);
            System.out.println("收到消息 :" + msg.getText());
            if (msg.getText().equals("end")) {
//                isContinue = false;
                System.out.println("收到退出消息，程序要退出！");

            }
        }
        System.out.println("程序退出了！");
    }
}