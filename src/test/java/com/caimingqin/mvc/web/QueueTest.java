package com.caimingqin.mvc.web;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

import com.caimingqin.app.defaults.DefualtDomainEventPublisherObservable;
import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.interfaces.DomainEventPublisher;
import com.caimingqin.app.model.Car;
import com.caimingqin.app.model.Distributor;

public class QueueTest {

	@Test
	public void test(){
	String eventName="addCar";
		Queue<DomainEvent> all=new ConcurrentLinkedQueue<DomainEvent>();
		DomainEvent domainEvent = new DomainEvent(eventName, new Car("codeadd", "name"));
		domainEvent.addContextProperty("year", "2012");
		all.add(domainEvent);
		all.add(new DomainEvent("updateCar", new Distributor("codeupdate", "name","name")));
		all.add(new DomainEvent("deleteCar", new Car("codedelete", "name")));
		boolean b=true;
		while(b){
			DomainEvent poll = all.poll();
			if(poll!=null&&eventName.equalsIgnoreCase(poll.getName())){
//				System.out.println(poll.getName()+" "+poll.getObj().getName()+" "+poll.getObj().getCode());
				String year=(String) domainEvent.getContextProperty("year");
			Car c=	(Car) poll.getTarget();
			System.out.println(c.getName()+" "+year);
			}
			if(all.size()==0){
				b=false;
			}
		}
	}
	
	@Test
	public void test2(){
		for(int i=0;i<10;i++){
			
			DomainEventPublisher single=DefualtDomainEventPublisherObservable.getSingle();
			System.out.println(single);
		}
	}
}
