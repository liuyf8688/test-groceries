package test;



public class TestPassByValue {
	
	public static void main(String[] args) {
		
		StringBuffer buffer = new StringBuffer("abc");
		//
		modifyHoldedValueByObject(buffer);
		System.out.println("After modifying value: " + buffer.toString());
		//
		modifyObjectReference(buffer);
		System.out.println("After modifying reference: " + buffer.toString());
	}
	
	private static void modifyHoldedValueByObject(StringBuffer buffer) {
		System.out.println("Before modifying value: " + buffer);
		buffer.append("defg");
	}

	public static void modifyObjectReference(StringBuffer buffer) {
		System.out.println("Before modifying reference: " + buffer);
		buffer = new StringBuffer("cba");
	}

}
