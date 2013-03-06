package com.caimingqin.app.evnetHandler;

import com.caimingqin.app.annotation.AutoEvent;
import com.caimingqin.app.event.DomainEvent;

public class DistributorEventHaldler {

	@AutoEvent(name = "createDistributor")
	public void createDistributorHaldler(DomainEvent domainEvent) {
     System.out.println("createDistributorHaldler===>"+domainEvent);
	}

}
