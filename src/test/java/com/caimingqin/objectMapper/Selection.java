package com.caimingqin.objectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Selection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -971939337588771093L;
	private String code;
	private String name;
	private String type;
	private List<Selection>  children=new ArrayList<Selection>();
	public Selection() {
	}
	
	
	public Selection(String code, String name, String type) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
	}


	public String getCode() {
		return code;
	}


	public String getName() {
		return name;
	}


	public String getType() {
		return type;
	}


	public List<Selection> getChildren() {
		return children;
	}
	
	public void addChildren(Selection children){
		this.children.add(children);
	}
}
