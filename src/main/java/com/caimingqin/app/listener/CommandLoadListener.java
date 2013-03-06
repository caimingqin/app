package com.caimingqin.app.listener;

import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.caimingqin.app.command.CreateCarCommand;
import com.caimingqin.app.command.CreateDistributorCommand;
import com.caimingqin.app.command.DeleteCarCommand;
import com.caimingqin.app.defaults.DefualtDomainEventPublisherObservable;
import com.caimingqin.app.defaults.DefualtDomainEventPublisherObserve;
import com.caimingqin.app.interfaces.Command;

public class CommandLoadListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("CommandLoadListener==========load now");
		CommandContainer singleInstance = CommandContainer.getSingleInstance();
		Map<String, Class<? extends Command>> containerMap = singleInstance.getContainerMap();
		containerMap.put("CreateCarCommand", CreateCarCommand.class);
		containerMap.put("CreateDistributorCommand", CreateDistributorCommand.class);
		containerMap.put("DeleteCarCommand", DeleteCarCommand.class);
		
		System.out.println("containerMap======>"+containerMap.size());
		
		DefualtDomainEventPublisherObserve observer = new DefualtDomainEventPublisherObserve();
		DefualtDomainEventPublisherObservable single = DefualtDomainEventPublisherObservable.getSingle();
		single.addObserver(observer);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
