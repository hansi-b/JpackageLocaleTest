package loc_test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class App {
	public static final Locale locale = Locale.GERMANY;

	private static final DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(locale);
	static {
		df.setParseBigDecimal(true);
	}

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(locale);

		System.out.println(String.format("locale = %s", Locale.getDefault()));
		for (String s : new String[] { "user.country", "user.language", "java.locale.providers" }) {
			System.out.println(String.format("%s = %s", s, System.getProperty(s)));
		}

		for (String s : new String[] { "2.815,53", "2815,53" }) {
			Number parsed = df.parse(s);
			System.out.println(String.format("%s \t-> %s (%s)", s, parsed, parsed.getClass()));
		}
	}
}
