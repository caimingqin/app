package com.caimingqin.mvc.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.caimingqin.app.model.Car;

public class ObjectMapperTest {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		String str = objectMapper.writeValueAsString(new Car("code", "name"));
		System.out.println(str);
	}
	
	@Test
	public void test2() throws JsonGenerationException, JsonMappingException, IOException{
	 InputStream in=new FileInputStream("D:/product.json");
		ObjectMapper objectMapper = new ObjectMapper();
		ProductQuantity value = objectMapper.readValue(in, ProductQuantity.class);
		System.out.println( value.getCode()+" "+value.getQuantity());
	}
}
