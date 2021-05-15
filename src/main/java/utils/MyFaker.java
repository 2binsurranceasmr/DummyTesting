package utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class MyFaker {

	public static Faker faker = new Faker();

	public static void setLocale(String locale) {
		faker = new Faker(new Locale(locale));
	}

	public static String getRandomizedFullName() {
		return MyFaker.faker.name().fullName();
	}
	
	public static String getRandomizedUsername() {
		return MyFaker.faker.name().username();
	}
	
	public static String getRandomizedPassword() {
		return MyFaker.faker.regexify("^[a-zA-Z0-9!@#$%^&*().,<>-=_+]{3,36}$");
	}
}
