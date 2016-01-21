package test;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class TestUnsafe {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafe.setAccessible(true);
		Unsafe unsafe = (Unsafe)theUnsafe.get(null);
//		
//		unsafe.setMemory(null, 0L, 0L, (byte)0);
//		unsafe.setMemory(0L, 0L, (byte)0);
//		
//		System.out.println(unsafe);
		
		unsafe.throwException(new FileNotFoundException());
	}

}
