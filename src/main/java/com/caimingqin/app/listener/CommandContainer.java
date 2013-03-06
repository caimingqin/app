package com.caimingqin.app.listener;

import java.util.HashMap;
import java.util.Map;

import com.caimingqin.app.interfaces.Command;

public class CommandContainer {

	private Map<String, Class<?extends Command>> containerMap=new HashMap<String,  Class<?extends Command>>();
	
	private static final CommandContainer container=new CommandContainer();
	
	public static CommandContainer getSingleInstance(){
		return container;
	}

	public Map<String, Class<?extends Command>> getContainerMap() {
		return containerMap;
	}
}
