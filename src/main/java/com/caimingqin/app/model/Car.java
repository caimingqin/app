package com.caimingqin.app.model;

import java.io.Serializable;

public class Car implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  code;
	private String name;
	
	public Car() {
	}
	public Car(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	
	
}
