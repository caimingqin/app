package com.caimingqin.app.interfaces;

import com.caimingqin.app.event.DomainEvent;

public interface DomainEventHandler {
 
	void handle(DomainEvent domainEvent);
}
