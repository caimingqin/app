package com.caimingqin.app.proxy;

import org.junit.Test;

import com.caimingqin.app.model.Car;


public class ProxyTest {

	@Test
	public void testCglib(){//����Ҫ�ӿ�
	CarServiceProxyCglib proxyCglib = new CarServiceProxyCglib();
	CarServiceImplCglib impl=(CarServiceImplCglib) proxyCglib.getInstance(new CarServiceImplCglib());
	impl.addCar(new Car());
	}
	
	@Test
	public void testA(){//��Ҫ�ӿ�
		CarServiceProxy proxy = new CarServiceProxy();
		CarService cs=(CarService) proxy.bind(new CarServiceImpl());
		cs.addCar(new Car());
	}
	
	
}
