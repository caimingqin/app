package com.caimingqin.app.query;

import java.util.List;

import com.caimingqin.app.model.Car;
import com.caimingqin.app.model.Distributor;

public interface AppQuery {

	List<Car> findAllCars();
	List<Distributor> findAllDistributors();
}
