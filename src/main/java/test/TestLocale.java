package test;
import java.util.Locale;


public class TestLocale {

	public static void main(String[] args) {
		
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale locale : locales) {
			System.out.println(locale.getCountry() + " ===>>> " + locale.getLanguage());
		}
	}
}
