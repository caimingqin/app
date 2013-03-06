package com.caimingqin.app.query.jdbc;


import java.util.List;

import org.springframework.stereotype.Component;

import com.caimingqin.app.model.Car;
import com.caimingqin.app.model.Distributor;
import com.caimingqin.app.query.AppQuery;

@Component
public class JdbcAppQuery implements AppQuery {

	@Override
	public List<Car> findAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Distributor> findAllDistributors() {
		// TODO Auto-generated method stub
		return null;
	}

//	private JdbcTemplate jdbcTemplate;
//	private Map<String, List<?>> carCache = Hazelcast.getMap(App.APP_CACHE_CAR);
//	private Map<String, List<?>> distributorCache = Hazelcast.getMap(App.APP_CACHE_DISTRIBUTOR);
//	private List<Car> allCars = new ArrayList<Car>();
//	private List<Distributor> allDistributors = new ArrayList<Distributor>();
//	private static String findAllCars = "SELECT * FROM TB_CAR";
//	private static String findAllDistributors = "SELECT * FROM TB_DISTRIBUTOR";
//
//	@Resource(name="jdbcTemplate")  
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//		init();
//	}
//
//	private void init(){
//		loadData();
//		System.out.println(carCache.get(Car.class.getName()).size());
//		System.out.println(distributorCache.get(Distributor.class.getName()).size());
//
//	}
//	private void loadData() {
//		System.out.println("loadData start now =================");
//		allCars.clear();
//		jdbcTemplate.query(findAllCars, new RowCallbackHandler() {
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				String code = rs.getString("code");
//				String name = rs.getString("name");
//				allCars.add(new Car(code, name));
//
//			}
//		});
//		carCache.put(Car.class.getName(), allCars);
//		
//		allDistributors.clear();
//		jdbcTemplate.query(findAllDistributors, new RowCallbackHandler() {
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				String code = rs.getString("code");
//				String name = rs.getString("name");
//				String addr = rs.getString("addr");
//				allDistributors.add(new Distributor(code, name, addr));
//				
//			}
//		});
//		distributorCache.put(Distributor.class.getName(), allDistributors);
//		System.out.println("loadData end now =================");
//		
//	}
//
//	@Override
//	public List<Car> findAllCars() {
//		return allCars;
//	}
//
//	@Override
//	public List<Distributor> findAllDistributors() {
//		return allDistributors;
//	}

}
