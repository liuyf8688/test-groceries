package test;

public class TestMatchSpecificException {

	public static void main(String[] args) {
		
		// Should be matched the more specific exception
		try {
			int i = 10 / 0;
			System.out.println(i);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
