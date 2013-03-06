//
//package com.caimingqin.mvc.web;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import com.caimingqin.app.model.Car;
//import com.caimingqin.app.model.Distributor;
//import com.caimingqin.app.query.jdbc.JdbcAppQuery;
//
//public class DataSourceTest {
//
//	private static DriverManagerDataSource dataSource = null;
//	
//	static {
//		dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
//		dataSource.setUrl("jdbc:jtds:sqlserver://localhost;databasename=caimingqin");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("12345678");
//	}
//	
//	@Test
//	public void test(){
//		System.out.println("====================================================");
//	}
//	
//	@Test
//	public void test22(){
//		    ApplicationContext context = new ClassPathXmlApplicationContext("AppContext-eclipse.xml");
//		    JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//		    JdbcAppQuery jdbcAppQuery = new JdbcAppQuery();
//			jdbcAppQuery.setJdbcTemplate(jdbcTemplate);
//		    List<Car> allCar = jdbcAppQuery.findAllCars();
//			System.out.println(allCar);
//	}
//	
//	@Test
//	public void test33(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext-eclipse.xml");
//		String[] beanDefinitionNames = context.getBeanDefinitionNames();
//		for(String s:beanDefinitionNames){
//			System.out.println(s);
//		}
////		AppQuery jdbcAppQuery =context.getBean(AppQuery.class);
////		List<Car> allCar = jdbcAppQuery.findAllCars();
////		System.out.println(allCar);
//	}
//	
//	private static final String createCar="insert into tb_car values(?,?)";
//	@Test
//	public void testCreate(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext-eclipse.xml");
//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//		final List<Car> cars=new ArrayList<Car>();
//		for(int i=0;i<50000;i++){
//			cars.add(new Car("code"+i,"name"+i));
//		}
//		jdbcTemplate.batchUpdate(createCar, new BatchPreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				Car car = cars.get(i);
//				ps.setString(1, car.getCode());
//				ps.setString(2, car.getName());
//				
//			}
//			@Override
//			public int getBatchSize() {
//				// TODO Auto-generated method stub
//				return cars.size();
//			}
//		});
//	}
//	private static final String createDis="insert into tb_distributor values(?,?,?)";
//	@Test
//	public void testCreate12(){
////		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext-eclipse.xml");
////		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		final List<Distributor> cars=new ArrayList<Distributor>();
//		for(int i=0;i<3000;i++){
//			cars.add(new Distributor("code"+i,"name"+i,"address"+i));
//		}
//		jdbcTemplate.batchUpdate(createDis, new BatchPreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				Distributor car = cars.get(i);
//				ps.setString(1, car.getCode());
//				ps.setString(2, car.getName());
//				ps.setString(3, car.getAddr());
//				
//			}
//			@Override
//			public int getBatchSize() {
//				// TODO Auto-generated method stub
//				return cars.size();
//			}
//		});
//	}
//}
