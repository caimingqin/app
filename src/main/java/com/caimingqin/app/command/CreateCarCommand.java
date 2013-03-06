package com.caimingqin.app.command;

import org.springframework.stereotype.Service;

import com.caimingqin.app.defaults.DefualtDomainEventPublisherObservable;
import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.interfaces.Command;
import com.caimingqin.app.interfaces.DomainEventPublisher;
import com.caimingqin.app.model.Car;

@Service
public class CreateCarCommand implements Command {
    
	DomainEventPublisher publisher=DefualtDomainEventPublisherObservable.getSingle();
	
	@Override
	public Object excute() {
		Car car = new Car("createCar", "mmmm");
		DomainEvent domainEvent = new DomainEvent("createCar", car);
		System.out.println("=========================>excute() "+publisher);
		publisher.publish(domainEvent);
		return car;
	}

}
