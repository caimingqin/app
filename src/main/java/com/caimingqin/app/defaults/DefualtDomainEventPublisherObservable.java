package com.caimingqin.app.defaults;

import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.interfaces.DomainEventPublisher;

public class DefualtDomainEventPublisherObservable  extends Observable implements DomainEventPublisher{

	private Queue<DomainEvent> eventsQueue;
	private static final DefualtDomainEventPublisherObservable single = new DefualtDomainEventPublisherObservable();

	public DefualtDomainEventPublisherObservable() {
		// eventsQueue=new ConcurrentLinkedQueue<DomainEvent>();
		eventsQueue = new ArrayBlockingQueue<DomainEvent>(1000);
	}

	// public static DomainEventPublisher getSingle() {
	// return single;
	// }
	public static DefualtDomainEventPublisherObservable getSingle() {
		return single;
	}

	 @Override
	 public void publish(DomainEvent domainEvent) {
	 System.out.println("publish domainEvent now");
	 super.setChanged();
	 notifyObservers(domainEvent);
	 // eventsQueue.add(domainEvent);
	 }

	public Queue<DomainEvent> getEventsQueue() {
		return eventsQueue;
	}

}
