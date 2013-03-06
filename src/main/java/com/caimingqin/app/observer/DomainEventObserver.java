package com.caimingqin.app.observer;

import java.util.Observable;
import java.util.Observer;

public class DomainEventObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(o.getClass()+" "+arg.toString());
		
	}

}
