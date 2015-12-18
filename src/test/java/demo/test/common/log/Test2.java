package demo.test.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test2 {

	private static Log log = LogFactory.getLog(Test2.class);
	
	public static void main(String[] args) {
	
		log.info("startTime: " + System.currentTimeMillis());
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("endTime: " + System.currentTimeMillis());
	}
}
