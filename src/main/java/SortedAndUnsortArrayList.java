import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortedAndUnsortArrayList {
	
	public static void main(String[] args) {
		
		int len = 65536;
		List<Integer> datas = new ArrayList<>();
		
		int index = 10000;
		int value = 0;
		
		int placeholder;
		
		Random rnd = new Random(System.currentTimeMillis());
		for (int c = 0; c < len; ++c) {
			placeholder = rnd.nextInt();
			if (c == index) {
				value = placeholder; 
			}
			datas.add(placeholder);
		}
		
//		Collections.sort(datas);
		logTime(datas, value);
		
	}

	private static void logTime(List<Integer> datas, int value) {
		int index;
		long start = System.nanoTime();
		index = datas.indexOf(value);
		long spentTime = System.nanoTime() - start;
		System.out.println("index: " + index + ", spentTime is " + spentTime);
	}

}
