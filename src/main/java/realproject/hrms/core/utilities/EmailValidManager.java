package realproject.hrms.core.utilities;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidManager {
	
	public static boolean isEmailValid(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	public static boolean isEmailEqualsWebAdress(String website, String email){

		int index = email.indexOf('@');
		String mail = email.substring(index+1);
		return website.equals(mail);
	}

}
