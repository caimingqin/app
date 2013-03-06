package com.caimingqin.app.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caimingqin.app.model.Car;
import com.caimingqin.app.model.Distributor;
import com.caimingqin.app.query.AppQuery;

@Controller
@RequestMapping("common")
public class CommonController {
    
	@Resource
	private AppQuery appQuery;

	@ResponseBody
	@RequestMapping("/cars")
	public List<Car> findAllCar() {
		System.out.println("findCar----------------");
		List<Car> cars = appQuery.findAllCars();
		return cars;
	}
	
	@ResponseBody
	@RequestMapping("/car")
	public Car findCar() {
		System.out.println("findCar----------------");
		return new Car("dddss", "dog");
	}
	
	@ResponseBody
	@RequestMapping("/distributors")
	public List<Distributor> findAllDistributors() {
		System.out.println("findAllDistributors now");
		return appQuery.findAllDistributors();
	}
	
	@ResponseBody
	@RequestMapping("/test/{name}/{typeName}/{pageNun}")
	public List<Distributor> findAllDistributorsTEST(@PathVariable String name,
													@PathVariable String typeName, 
													@PathVariable int pageNun,
													HttpServletRequest req) {
		String parameter = req.getParameter("name2");
		System.out.println("findAllDistributorsTEST now" + name + " "
				+ parameter + " " + typeName + " " + pageNun);
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/{params}")
	public void paramsTest(@PathVariable String params) {
		System.out.println("params=================>"+params.toString());
	}
}
