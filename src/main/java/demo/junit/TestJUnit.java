package demo.junit;

import org.junit.Assert;
import org.junit.Test;

public class TestJUnit {

	@Test
	public void testSuccess() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testFail() {
		Assert.fail("Not implemented yet");
	}
}
