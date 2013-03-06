package com.caimingqin.app.proxy;

import org.junit.Test;

import com.caimingqin.app.model.Car;


public class ProxyTest {

	@Test
	public void testCglib(){//不需要接口
	CarServiceProxyCglib proxyCglib = new CarServiceProxyCglib();
	CarServiceImplCglib impl=(CarServiceImplCglib) proxyCglib.getInstance(new CarServiceImplCglib());
	impl.addCar(new Car());
	}
	
	@Test
	public void testA(){//需要接口
		CarServiceProxy proxy = new CarServiceProxy();
		CarService cs=(CarService) proxy.bind(new CarServiceImpl());
		cs.addCar(new Car());
	}
	
	
}
