package com.caimingqin.app.jms;

import org.springframework.jms.core.JmsTemplate;

public class MessageSender {  
	   // ~~~ jmsTemplate  
	   public JmsTemplate jmsTemplate;  
	     
	   /** 
	    * send message 
	 * @throws InterruptedException 
	    */  
	   public void sendMessage(Object  obj) throws InterruptedException{  
	       jmsTemplate.convertAndSend(obj);  
//	       jmsTemplate.setTimeToLive(100);
	   }  
	   public void setJmsTemplate(JmsTemplate jmsTemplate) {  
	       this.jmsTemplate = jmsTemplate;  
	   }  
	}  
