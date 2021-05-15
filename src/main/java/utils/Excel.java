package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	private static XSSFSheet myExcelWSheet;

	private static XSSFWorkbook myExcelWBook;

	private static XSSFCell theCell;

	private static XSSFRow theRow;

	public static void setExcelFile(String path, String sheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream excelFile = new FileInputStream(path);

			// Access the required test data sheet

			myExcelWBook = new XSSFWorkbook(excelFile);

			myExcelWSheet = myExcelWBook.getSheet(sheetName);

		} catch (Exception e) {

			throw (e);

		}

	}
	// read form one cell

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			theCell = myExcelWSheet.getRow(RowNum).getCell(ColNum);

			String cellData = theCell.getStringCellValue();

			return cellData;

		} catch (Exception e) {

			return "";

		}

	}
	
	// insert data to one cell
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {

			theRow = myExcelWSheet.getRow(RowNum);
			if(theRow==null) {
				theRow=myExcelWSheet.createRow(RowNum);
			}

			theCell = theRow.getCell(ColNum, theRow.RETURN_NULL_AND_BLANK);

			if (theCell == null) {

				theCell = theRow.createCell(ColNum);

				theCell.setCellValue(Result);

			} else {

				theCell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

			myExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}
