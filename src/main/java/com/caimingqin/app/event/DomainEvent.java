package com.caimingqin.app.event;

import java.util.HashMap;
import java.util.Map;

public class DomainEvent {

	private String ownerId;
	private String name;
	private Object target;
	private Map<String, Object> contextMap = new HashMap<String, Object>();

	public DomainEvent() {
	}

	public DomainEvent(String name, Object target) {
		this(null, name, target);
	}

	public DomainEvent(String ownerId, String name, Object target) {
		this.ownerId = ownerId;
		this.name = name;
		this.target = target;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getTarget() {
		return target;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void addContextProperty(String name, Object obj) {
		this.contextMap.put(name, obj);
	}

	public Object getContextProperty(String name) {
		return contextMap.get(name);
	}
}
