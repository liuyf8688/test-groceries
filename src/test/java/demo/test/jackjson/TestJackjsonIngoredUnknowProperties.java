package demo.test.jackjson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.pojos.AddressPojo;
import demo.pojos.UserPojo;

public class TestJackjsonIngoredUnknowProperties {
	
	private ObjectMapper objectMapper;
	
	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	@Test
	public void testPrimitiveProperty() throws JsonParseException, JsonMappingException, IOException {
		
		String text = "{ \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\", \"ABC\" : \"abc\" }";
		UserPojo userPojo = objectMapper.readValue(text, UserPojo.class);
		
		Assert.assertEquals("Yanfeng", userPojo.getFirstName());
		Assert.assertEquals("Liu", userPojo.getLastName());
		Assert.assertTrue(userPojo.isMale());
		
	}
	
	@Test
	public void testObjectProperty() throws JsonParseException, JsonMappingException, IOException {
		
		String text = "{ \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\", \"ABC\" : { \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\" } }";
		UserPojo userPojo = objectMapper.readValue(text, UserPojo.class);
		
		Assert.assertEquals("Yanfeng", userPojo.getFirstName());
		Assert.assertEquals("Liu", userPojo.getLastName());
		
	}
	
	@Test
	public void testObjectWithJsonIgnoreProperties() throws JsonParseException, JsonMappingException, IOException {
		
		String text = "{ \"street\" : \"Road GuangHuang\", \"city\" : \"Beijing\", \"ABC\" : { \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\" } }";
		AddressPojo addressPojo = objectMapper.readValue(text, AddressPojo.class);
		
		Assert.assertEquals("Road GuangHuang", addressPojo.getStreet());
		Assert.assertEquals("Beijing", addressPojo.getCity());
		
	}


}
