package com.caimingqin.app.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadAppResourceListner implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		ServletContext sc = sce.getServletContext();
//		String url = sc.getRealPath("/");
//		String file = url+"WEB-INF/AppContext.xml";
	    ApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
	    String[] beanDefinitionNames = context.getBeanDefinitionNames();
	    for(String s:beanDefinitionNames){
	    	System.out.println("bean===>"+s);
	    }
		
	}

}
