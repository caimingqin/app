package com.caimingqin.app.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.caimingqin.app.defaults.DefualtDomainEventPublisherObservable;
import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.interfaces.Command;
import com.caimingqin.app.interfaces.DomainEventPublisher;
import com.caimingqin.app.model.Car;

public class DeleteCarCommand implements Command {
    
	@Autowired
	DomainEventPublisher publisher=DefualtDomainEventPublisherObservable.getSingle();
	@Override
	public Object excute() {
		DomainEvent domainEvent = new DomainEvent("deleteCar", new Car("deleteCar", "name"));
		publisher.publish(domainEvent);
		System.out.println("=========================>excute()");
		return 200;
	}

}
