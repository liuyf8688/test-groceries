package demo.pojos;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;

public class TestClassUtils {

	
	public static void main(String[] args) {
		
		List<Class<?>> interfaces = ClassUtils.getAllInterfaces(Integer.class);
		for (Class<?> clazz : interfaces) {
			System.out.println(clazz);
		}
		
		System.out.println("===============================");
		List<Class<?>> superClasses = ClassUtils.getAllSuperclasses(Integer.class);
		for (Class<?> clazz : superClasses) {
			System.out.println(clazz);
		}
		
		System.out.println("===============================");
		Class<?>[] javaInterfaces = Integer.class.getInterfaces();
		for (Class<?> clazz : javaInterfaces) {
			System.out.println(clazz);
		}
		
		System.out.println("===============================");
		Class<?> javaSuperClasses = Integer.class.getSuperclass();
		System.out.println(javaSuperClasses);
		
	}
}
