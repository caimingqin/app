package com.caimingqin.app.listener;

import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;

public class HazelcastLoadListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Start Hazelcast now=========================================>>");
		ServletContext sc = sce.getServletContext();
		String url = sc.getRealPath("/");
		System.out.println("url: "+url);
		String file = url+"WEB-INF/haz.xml";
		System.out.println("file: "+file);
		try {
			Config x = new XmlConfigBuilder(file).build();
			Hazelcast.init(x);
		} catch (FileNotFoundException e) {
			System.out.print("not found file["+file+"]");
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		Hazelcast.getLifecycleService().shutdown();
	}


}
