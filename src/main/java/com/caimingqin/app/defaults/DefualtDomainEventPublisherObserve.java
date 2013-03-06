package com.caimingqin.app.defaults;

import java.lang.reflect.Method;
import java.util.Observable;
import java.util.Observer;
import com.caimingqin.app.annotation.AutoEvent;
import com.caimingqin.app.event.DomainEvent;


public class DefualtDomainEventPublisherObserve implements Observer {
	
	@Override
	public void update(Observable o, Object domainEvent) {
		System.out.println("handle domainEvent  now");
		try {
			if (domainEvent instanceof DomainEvent) {
				DomainEvent target = (DomainEvent) domainEvent;
				String[] eventHandlers = { "com.caimingqin.app.evnetHandler.CommonEventHaldler",
				"com.caimingqin.app.evnetHandler.DistributorEventHaldler" };
				for (String className : eventHandlers) {// enventHandler½âÎö
					Class<?> clazz = Class.forName(className);
					Object newInstance = clazz.newInstance();
					Method[] methods = clazz.getDeclaredMethods();
					for (Method m : methods) {
						boolean b = m.isAnnotationPresent(AutoEvent.class);
						if (b) {
							AutoEvent event = m.getAnnotation(AutoEvent.class);
							if (event.name().equals(target.getName())) {
								m.invoke(newInstance, domainEvent);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception when handle domainEvent " +e.getMessage());
		}
	}

	

}
