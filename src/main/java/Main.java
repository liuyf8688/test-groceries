import java.sql.Date;
import java.text.DateFormat;
import java.time.ZoneId;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) {
		DateFormat df = DateFormat.getDateTimeInstance();
		df.setTimeZone(TimeZone.getTimeZone(ZoneId.of("Europe/Berlin")));
		System.out.println(df.format(new Date(1447138800000L)));
		
		System.out.println("==========================================");
		
		System.out.println(df.format(new Date(1447142400000L)));
	}
}
