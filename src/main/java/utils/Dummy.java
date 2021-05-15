package utils;

import com.github.javafaker.Faker;

public class Dummy {

	public enum Field {
		USER_NAME, PASSWORD, FULL_NAME
	}


	public Dummy(String path, String sheetName) {
		try {
			Excel.setExcelFile(path, sheetName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void dumping(String[] result, int amount, int rowStart, int col) {
		int index = 0;
		for (int i = rowStart; i < amount; i++) {
			try {
				Excel.setCellData(result[index++], i, col);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
	}

	public String[] createDummyData(int amount, Field f) {

		switch (f) {
		
		case FULL_NAME:
			return createFullName(amount);
			
		case USER_NAME:
			return createUserName(amount);
			
		case PASSWORD:
			return createPassword(amount);

		default:
			return null;
		}
	}
	public String[] createDummyData(int amount, Field f, String locale) {

		switch (f) {
		
		case FULL_NAME:
			MyFaker.setLocale(locale);
			return createFullName(amount);
			
		case USER_NAME:
			MyFaker.setLocale(locale);
			return createUserName(amount);
			
		case PASSWORD:
			MyFaker.setLocale(locale);
			return createPassword(amount);

		default:
			return null;
		}
	}

	private String[] createFullName(int amount) {
		String[] s = new String[amount];
		for(int i =0;i<amount;i++) {
			s[i]=MyFaker.getRandomizedFullName();
		}
		return s;
	}

	private String[] createUserName(int amount) {
		String[] s = new String[amount];
		for(int i =0;i<amount;i++) {
			s[i]=MyFaker.getRandomizedUsername();
		}
		return s;
	}

	private String[] createPassword(int amount) {
		String[] s = new String[amount];
		for(int i =0;i<amount;i++) {
			s[i]=MyFaker.getRandomizedPassword();
		}
		return s;
	}

}
