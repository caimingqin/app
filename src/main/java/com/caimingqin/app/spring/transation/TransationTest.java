
package com.caimingqin.app.spring.transation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransationTest {
	private Log logger=LogFactory.getLog(this.getClass().getName());
	private static DriverManagerDataSource dds = null;
	static {

		dds = new DriverManagerDataSource();
		dds.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
		dds.setUrl("jdbc:jtds:sqlserver://[];databasename=[]");
		dds.setUsername("");
		dds.setPassword("");
	}

	@Test
	public void tx(){
	    //spring编程式事物处理
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dds);
		PlatformTransactionManager ptm =new  DataSourceTransactionManager(dds);
		TransactionStatus status = ptm.getTransaction(new DefaultTransactionDefinition());

		try {
			jdbcTemplate.update("insert  INTO DC_DIST_BASE_DATA  ( DC_CD,BASE_YYMM ) values('S0000099','201807')");
			jdbcTemplate.update("insert  INTO DC_DIST_BASE_DATA  ( DC_CD,BASE_YYMM ) values('S0000099','201805')");
			ptm.commit(status);
		} catch (Exception e ) {
			ptm.rollback(status);
			logger.error("rollback===========================>>>>"+e.getMessage());
		}
	}
}
