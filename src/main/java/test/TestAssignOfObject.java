package test;

public class TestAssignOfObject {

	public static void main(String[] args) {
		
		StringBuffer first = new StringBuffer("abc");
		
		StringBuffer second = first;
		
		first = new StringBuffer("cba");
		
		System.out.println(first.toString());
		System.out.println(second.toString());
		
	}
}
