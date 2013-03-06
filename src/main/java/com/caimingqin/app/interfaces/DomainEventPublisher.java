package com.caimingqin.app.interfaces;

import java.util.Queue;

import com.caimingqin.app.event.DomainEvent;

public interface DomainEventPublisher {

	void publish(DomainEvent domainEvent);
	Queue<DomainEvent> getEventsQueue();
}
