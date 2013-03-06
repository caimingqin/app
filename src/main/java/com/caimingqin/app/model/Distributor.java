package com.caimingqin.app.model;

import java.io.Serializable;

public class Distributor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1017515618923293623L;

	private String code;
	private String name;
	private String addr;
	public Distributor() {
		super();
	}
	public Distributor(String code, String name, String addr) {
		super();
		this.code = code;
		this.name = name;
		this.addr = addr;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	
}
