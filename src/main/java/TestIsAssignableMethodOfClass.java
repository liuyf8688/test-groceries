
public class TestIsAssignableMethodOfClass {
	
	public static void main(String[] args) {
		
		Integer _int = new Integer(1);
		
		System.out.println(Number.class.isAssignableFrom(_int.getClass()));
		
		System.out.println(Integer.class.isAssignableFrom(_int.getClass()));
		
		Double _double = new Double(10);
		
		System.out.println(Number.class.isAssignableFrom(_double.getClass()));
		System.out.println(Integer.class.isAssignableFrom(_double.getClass()));
		
		//
		
		System.out.println(_double.getClass().isAssignableFrom(Integer.class));
		
		System.out.println(_double.getClass().isAssignableFrom(Number.class));
	}

}
