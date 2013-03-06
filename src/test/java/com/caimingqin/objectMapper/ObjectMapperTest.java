package com.caimingqin.objectMapper;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class ObjectMapperTest {

	@Test
	public void test() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Selection selection = new Selection("总部", "0000", "A");
		Selection head = new Selection("本部", "2110", "B");
		Selection area = new Selection("2101", "", "B");
		 Selection office = new Selection("110", "", "D");
		 Selection emp = new Selection("10001857", "李逵", "E");
		 Selection route = new Selection("L000", "路线", "F");
		 emp.addChildren(route);
		 office.addChildren(emp);
		 area.addChildren(office);
		 head.addChildren(area);
		Selection selection3 = new Selection("2102", "", "B");
		Selection selection4 = new Selection("2103", "", "B");
		Selection selection5 = new Selection("2104", "", "B");
		
		selection.addChildren(head);
		selection.addChildren(selection3);
		selection.addChildren(selection4);
		selection.addChildren(selection5);
		
		String writeValueAsString = objectMapper.writeValueAsString(selection);
		System.out.println(writeValueAsString);
		
	}
}
