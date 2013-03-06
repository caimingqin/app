package com.caimingqin.app.evnetHandler;

import com.caimingqin.app.annotation.AutoEvent;
import com.caimingqin.app.event.DomainEvent;
import com.caimingqin.app.model.Car;

public class CommonEventHaldler {

//	private static final String createCar="insert into tb_car values(?,?)";
	

	@AutoEvent(name="deleteCar")
	public void deleteCarhandler(DomainEvent de){
		System.out.println("deleteCarhandler=========>>"+de);
		Car c=(Car) de.getTarget();
		System.out.println(de.getName()+" "+c.getName());
		
	}
	
	@AutoEvent(name="createCar")
	public void createCarhandler(DomainEvent de) {
		System.out.println("createCarhandler=========>>"+de);
		Car c=(Car) de.getTarget();
		System.out.println(de.getName()+" "+c.getName()+"this.jdbcTemlate ");
//		TransactionStatus transaction = manager.getTransaction(null);
//	    this.jdbcTemplate.getDataSource().getConnection().setAutoCommit(false);
//		this.jdbcTemplate.update(createCar, new Object[]{c.getCode(),c.getName()});
//		manager.commit(transaction);
	}
	
	@AutoEvent(name="updateCar")
	public void updateCarhandler(DomainEvent de){
		System.out.println("deleteCarhandler=========>>"+de);
		Car c=(Car) de.getTarget();
		System.out.println(de.getName()+" "+c.getName());
	}
	
}
