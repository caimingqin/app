package com.caimingqin.app.executor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.caimingqin.app.annotation.AutoEvent;
import com.caimingqin.app.defaults.DefualtDomainEventPublisherObservable;
import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.interfaces.DomainEventPublisher;

public class MianTest{

	/**
	 * @param args
	 */
	 private Executor executor = Executors.newCachedThreadPool();
	
	 public  void test(){
		 executor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("==============>");
				while(true){
					handle();
				}
				
			}
		}); 
	 }

	 public void handle(){
		 try {
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
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }
	 public static void main(String[] args) {
		 MianTest mianTest = new MianTest();
		 mianTest.test();
	}
	
}
