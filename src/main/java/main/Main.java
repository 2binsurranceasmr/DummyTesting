package main;

import java.io.File;

import utils.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(MyFaker.getRandomizedFullName());
//		System.out.println(MyFaker.getRandomizedUsername().replaceAll("[.]", "_"));
//		File f = new File("");
//		System.out.println(f.getAbsolutePath());
//		try {
//			Excel.setExcelFile(Constant.Path_TestData + "DummyAccount.xlsx", "Sheet1");
//		}
//		catch(Exception e) {
//			System.out.println(e);
//			System.out.println("khong tim thay file");
//		}
//		try {
//			System.out.println(Excel.getCellData(1, 1));
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//			System.out.println("khong doc duoc data");
//		}
//		
//		try {
//			Excel.setCellData(MyFaker.getRandomizedFullName(), 2, 1);
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//			System.out.println("khong ghi duoc data");
//		}
		Dummy dump = new Dummy(Constant.Path_TestData + Constant.File_TestData, "sheet1");
		
		String[] data = dump.createDummyData(1000, Dummy.Field.USER_NAME);
		dump.dumping(data, data.length, 1, 0);
		System.out.println("finish");
	}
	
	
	
	

}
