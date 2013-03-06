package com.caimingqin.app.rs;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;


@Component
public class JdbcProductQuery implements ProductQuery{
	
	private static final String productQueryAll="SELECT (SELECT NAME FROM BASEDB..PRDLEVEL_A " +
	"WHERE CODE = SUBSTRING(A.HIERARCHY,1,2)) AS NAME1  , " +
	"(SELECT NAME FROM BASEDB..PRDLEVEL_A WHERE CODE = SUBSTRING(A.HIERARCHY,1,6)) AS NAME2, " +
	"A.PRDCD, A.PRDDSC , " +
	"(CASE WHEN ISNULL(B.SKUQTY,'') = '' THEN A.SKUQTY ELSE B.SKUQTY END) AS SKUQTY , " +
	"(CASE WHEN ISNULL(B.BARCODE,'') = '' THEN A.BARCODE ELSE B.BARCODE END) " +
	"AS BARCODE , A.TXPRIC, " +
	"(CASE WHEN ISNULL(B.USE_FLAG,'N') = 'N' THEN 'N' ELSE 'Y' END) AS USE_FLAG " +
	"  FROM BASEDB..PRODUCT_B A LEFT JOIN RSDB_N..T_RS_PRODUCT B ON A.PRDCD = B.PROCD " ;//LIKE '20%'
	
	private static final String productQuery= productQueryAll+"WHERE  A.HIERARCHY LIKE $condition ";//LIKE '20%'
	
	@Resource(name="jdbcTemplate-rs")
	private JdbcTemplate jdbcTemplate;
	
	
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
	
	public List<Product> findProductByCondition(String condition) {
		final List<Product> some=new ArrayList<Product>();
		String temp=null;
		if("isnull".equalsIgnoreCase(condition)){
			temp=productQueryAll;
		}else{
			temp=productQuery.replaceAll("\\$condition ", "'"+condition+"%'");
		}
		System.out.println(temp);
		this.jdbcTemplate.query(temp,new RowCallbackHandler() {
			
			public void processRow(ResultSet rs) throws SQLException {
				String typeName1 = rs.getString("NAME1");
				String typeName2 = rs.getString("NAME2");
				String code = rs.getString("PRDCD").trim();
				String name = rs.getString("PRDDSC");
				int productSize = rs.getInt("SKUQTY");
				String barCode = rs.getString("BARCODE");
				BigDecimal price = rs.getBigDecimal("TXPRIC");
				String useYN = rs.getString("USE_FLAG");
				some.add(new Product(code, name, price, barCode, useYN, productSize, typeName1, typeName2));
			}
		});
		return some;
	}

	

}
