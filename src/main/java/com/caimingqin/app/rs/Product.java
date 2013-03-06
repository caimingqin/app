package com.caimingqin.app.rs;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{

	/**
	 * @author caimingqin
	 */
	private static final long serialVersionUID = -6418260022065132136L;

	private String code;
	private String name;
	private BigDecimal price;
	private String barCode;
	private String useYN;
	private int   productSize;
	private String typeName1;//品类名称
	private String typeName2;//品种名称
	
	public Product() {	}

	public Product(String code, String name,BigDecimal price,String barCode, String useYN, int productSize,
			String typeName1, String typeName2) {
		this.code = code;
		this.name=name;
		this.price=price;
		this.barCode = barCode;
		this.useYN = useYN;
		this.productSize = productSize;
		this.typeName1 = typeName1;
		this.typeName2 = typeName2;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getBarCode() {
		return barCode;
	}

	public String getUseYN() {
		return useYN;
	}

	public int getProductSize() {
		return productSize;
	}

	public String getTypeName1() {
		return typeName1;
	}

	public String getTypeName2() {
		return typeName2;
	}


}
