import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		
		List<Integer> arrays = new LinkedList<>();
		arrays.add(1);
		arrays.add(2);
		arrays.add(9);
		arrays.add(7);
		
		for (Integer i : arrays) {
			System.out.println(i);
		}
	}
}
