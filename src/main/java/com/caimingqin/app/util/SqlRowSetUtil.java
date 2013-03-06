package com.caimingqin.app.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class SqlRowSetUtil {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> getObjectList(SqlRowSet rs, Class clazz,
			String[] params) {
		Field[] fields = clazz.getDeclaredFields();
		Constructor[] constructors = clazz.getDeclaredConstructors();
		List<T> list = new ArrayList<T>();
		while (rs.next()) {
			Object[] objs = new Object[fields.length];
			for (int i = 0; i < params.length; i++) {
				if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.String")) {
					objs[i] = rs.getString(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.Math.BigDecimal")) {
					objs[i] = rs.getBigDecimal(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Integer")) {
					objs[i] = rs.getInt(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Long")) {
					objs[i] = rs.getLong(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Float")) {
					objs[i] = rs.getFloat(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Short")) {
					objs[i] = rs.getShort(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Boolean")) {
					objs[i] = rs.getBoolean(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Byte")) {
					objs[i] = rs.getByte(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.lang.Double")) {
					objs[i] = rs.getDouble(params[i]);
				} else if (fields[i].getType().getName()
						.equalsIgnoreCase("java.util.Date")) {
					objs[i] = rs.getDate(params[i]);
				}
			}
			try {
				list.add((T) constructors[1].newInstance(objs));
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
