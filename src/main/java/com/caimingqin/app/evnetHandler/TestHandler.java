package com.caimingqin.app.evnetHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

import org.junit.Test;

import com.caimingqin.app.annotation.AutoEvent;
import com.caimingqin.app.command.CreateCarCommand;
import com.caimingqin.app.command.CreateDistributorCommand;
import com.caimingqin.app.command.DeleteCarCommand;
import com.caimingqin.app.defaults.DefualtDomainEventPublisherObservable;
import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.interfaces.DomainEventPublisher;
import com.caimingqin.app.model.Car;

public class TestHandler {
	
	@Test
	public void test(){
		
		Class<CommonEventHaldler> clazz=CommonEventHaldler.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods){
			Annotation[] annotations = m.getAnnotations();
			for(Annotation a:annotations){
				Method[] annotationType = a.annotationType().getDeclaredMethods();
				for(Method md:annotationType){
					System.out.println(md.getName());
				}
				
				
			}
		}
	}
	
	@Test
	public void test2() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		DomainEvent domainEvent = new DomainEvent("deleteCar", new Car("codeadd", "name"));
		Class<CommonEventHaldler> clazz=CommonEventHaldler.class;
		CommonEventHaldler newInstance = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods){
			boolean b = m.isAnnotationPresent(AutoEvent.class);
			if(b){
				AutoEvent event = m.getAnnotation(AutoEvent.class);
//				System.out.println(event.name());
//				System.out.println(event.interceptors()[0]);
				if(event.name().equals(domainEvent.getName())){
			      m.invoke(newInstance, domainEvent); 
				}
			}
		}
	}
	
	@Test
	public void testCommand() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
		DeleteCarCommand command = new DeleteCarCommand();
		command.excute();
		CreateCarCommand createCarCommand = new CreateCarCommand();
		createCarCommand.excute();
		DomainEventPublisher single = DefualtDomainEventPublisherObservable.getSingle();
		Queue<DomainEvent> eventsQueue = single.getEventsQueue();
		while(eventsQueue.size()!=0){
			System.out.println("start"+eventsQueue.size());
			DomainEvent domainEvent = eventsQueue.poll();
			System.out.println("end"+eventsQueue.size());
			Class<CommonEventHaldler> clazz=CommonEventHaldler.class;
			CommonEventHaldler newInstance = clazz.newInstance();
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m:methods){
				boolean b = m.isAnnotationPresent(AutoEvent.class);
				if(b){
					AutoEvent event = m.getAnnotation(AutoEvent.class);
					System.out.println(event.interceptor());
					if(event.name().equals(domainEvent.getName())){
						m.invoke(newInstance, domainEvent); 
					}
				}
			}
		}
		
	}
	
	
	@Test
	public void testEvent() throws Exception{
		
			DeleteCarCommand command = new DeleteCarCommand();
			command.excute();
			CreateCarCommand createCarCommand = new CreateCarCommand();
			createCarCommand.excute();
			CreateDistributorCommand createDistributoCommand = new CreateDistributorCommand();
			createDistributoCommand.excute();
			DomainEventPublisher single = DefualtDomainEventPublisherObservable.getSingle();
			Queue<DomainEvent> eventsQueue = single.getEventsQueue();
			String[] eventHandlers={"com.caimingqin.app.evnetHandler.CommonEventHaldler",
			"com.caimingqin.app.evnetHandler.DistributorEventHaldler"};
			while(eventsQueue.size()!=0){
//			System.out.println("start"+eventsQueue.size());
				DomainEvent domainEvent = eventsQueue.poll();
//			System.out.println("end"+eventsQueue.size());
				for(String className:eventHandlers){//enventHandler½âÎö
					Class<?> clazz = Class.forName(className);
					Object newInstance = clazz.newInstance();
					Method[] methods = clazz.getDeclaredMethods();
					for(Method m:methods){
						boolean b = m.isAnnotationPresent(AutoEvent.class);
						if(b){
							AutoEvent event = m.getAnnotation(AutoEvent.class);
//						System.out.println(event.interceptor());
							if(event.name().equals(domainEvent.getName())){
								m.invoke(newInstance, domainEvent); 
							}
						}
					}
				}
			}
	}
}
