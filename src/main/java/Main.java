import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		System.out.println(new Date(1447138800000L).toGMTString());
		
		System.out.println("==========================================");
		
		System.out.println(new Date(1447142400000L).toGMTString());
	}
}
