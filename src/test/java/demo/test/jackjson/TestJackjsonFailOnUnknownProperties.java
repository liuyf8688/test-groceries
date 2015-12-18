package demo.test.jackjson;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

import demo.pojos.UserPojo;

public class TestJackjsonFailOnUnknownProperties {
	
	private ObjectMapper objectMapper;
	
	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		objectMapper.setAnnotationIntrospector(new NopAnnotationIntrospector() {
			private static final long serialVersionUID = -6254892942695416142L;
		});
	}

	@Test(expected = UnrecognizedPropertyException.class)
	public void test() throws JsonParseException, JsonMappingException, IOException {
		
		String text = "{ \"firstName\" : \"Yanfeng\", \"lastName\" : \"Liu\", \"ABC\" : \"abc\" }";
		UserPojo userPojo = objectMapper.readValue(text, UserPojo.class);
		
		Assert.assertEquals("Yanfeng", userPojo.getFirstName());
		Assert.assertEquals("Liu", userPojo.getLastName());
		
	}

}
