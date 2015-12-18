package test;



public class TestPassByValueUsingCustomClass {
	
	public static void main(String[] args) {
		
		TestOnly testOnly = new TestOnly("LiuMingYue");
		//
		modifyPropertyValueByObject(testOnly);
		System.out.println("After being modified property value: " + testOnly.getName());
		//
		modifyObjectReference(testOnly);
		System.out.println("After being modified reference: " + testOnly.getName());
		
	}
	
	private static void modifyPropertyValueByObject(TestOnly testOnly) {
		System.out.println("Before being modified property value: " + testOnly.getName());
		testOnly.setName("TonyLiu");
	}

	private static void modifyObjectReference(TestOnly testOnly) {
		System.out.println("Before modifying reference: " + testOnly.getName());
		testOnly = new TestOnly("MoonLiu");
	}
	
	static class TestOnly {
		
		private String name;

		public TestOnly(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

}
