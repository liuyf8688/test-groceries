package demo.test.jackjson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.pojos.UserPojo;

public class TestJackJsonSerialAndDeserial {

private ObjectMapper objectMapper;
	
	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		
		String text = "{ \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\", \"address\" : { \"street\" : \"Rd. GuangHua\"} }";
		UserPojo userPojo = objectMapper.readValue(text, UserPojo.class);
		Assert.assertEquals("Rd. GuangHua", userPojo.getAddress().getStreet());
		
		String expected = "{\"firstName\":\"Yanfeng\",\"lastName\":\"Liu\",\"age\":0,\"male\":true}";
		Assert.assertEquals(expected, objectMapper.writeValueAsString(userPojo));
	}
}
