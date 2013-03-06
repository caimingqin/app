package com.caimingqin.app.observer;

import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.model.Car;

public class DomainEventObservable extends Observable{
	private Queue<DomainEvent> all=new ConcurrentLinkedQueue<DomainEvent>();
	public void addDomainEvent(DomainEvent domainEvent){
		System.out.println("add DomainEvent now");
		this.all.add(domainEvent);
		super.setChanged();
		notifyObservers(this.all);
	}
	
	public static void main(String[] args) {
		DomainEventObservable observable = new DomainEventObservable();
		observable.addObserver(new DomainEventObserver());
		observable.addDomainEvent(new DomainEvent("add", new Car("codeadd", "name")));
		
		
	}
}
