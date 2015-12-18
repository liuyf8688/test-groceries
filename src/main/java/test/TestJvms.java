package test;
import java.util.ArrayList;
import java.util.List;

public class TestJvms {

	
	private static final int M = 1024 * 1024;
	
	public static void main(String[] args) throws InterruptedException {
		
		List<Byte[]> list = new ArrayList<Byte[]>();
		int i = 0;
		
		while (true) {
			
			list.add(new Byte[10 * M]);
			if (i == 10) {
				i = 0;
				list = new ArrayList<Byte[]>();
			}
			
			Thread.sleep(100);
			
			i ++;
		}
	}
	
}
