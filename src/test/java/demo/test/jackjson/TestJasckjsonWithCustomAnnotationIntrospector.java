package demo.test.jackjson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mongojack.internal.MongoAnnotationIntrospector;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import demo.pojos.UserPojo;

public class TestJasckjsonWithCustomAnnotationIntrospector {
	
	private ObjectMapper objectMapper;
	
	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
	
	@Test
	public void testMongoAnnotationIntrospector() throws JsonParseException, JsonMappingException, IOException {
		
		objectMapper.setAnnotationIntrospector(new MongoAnnotationIntrospector(objectMapper.getTypeFactory()));
		String text = "{ \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\", \"ABC\" : \"abc\" }";
		UserPojo userPojo = objectMapper.readValue(text, UserPojo.class);
		objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector());
		
		Assert.assertEquals("Yanfeng", userPojo.getFirstName());
	}
	
}
