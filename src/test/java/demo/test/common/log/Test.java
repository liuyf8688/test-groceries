package demo.test.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Test {

	static {
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDERR");
	}
	
	private static Log log = LogFactory.getLog(Test.class);
	
	public static void main(String[] args) {
	
		System.out.println("debug ===>>> " + log.isDebugEnabled());
		
		System.out.println("info ===>>> " + log.isInfoEnabled());
		
		System.out.println("warn ===>>> " + log.isWarnEnabled());
	}
}
