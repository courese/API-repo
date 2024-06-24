import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excelfilehandling_writedata {
	String filePath = "C:\\Users\\WIN\\eclipse-workspace\\Mavenprojectcreation\\src\\main\\java\\textfolder\\";
	String fileName = "excelfile.xlsx";
	
	public void writedata() throws IOException {
		File F = new File(filePath+fileName);
		FileOutputStream FS = new FileOutputStream(F);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet Outsheet = workbook.createSheet("sample"); // to create a new sheet in the workbook named as sample
		Row Outrow = Outsheet.createRow(0); // to create a new rwo in the workbook
		Cell Outcell = Outrow.createCell(0); // to create a new column in the workbook
		Outcell.setCellValue("Maha"); // giving the value to the cell (0,0 cell)
		workbook.write(FS); // write command to write the giving values in the workbook
		workbook.close(); // closing the workbook
		}
	
	public void writedata_with_multiplevalue() throws IOException {
		String[] name = {"Maha", "26", "java"};
		int totalValue = name.length; // it will read the count to create a row and column
		File F = new File(filePath+fileName);
		FileOutputStream FS = new FileOutputStream(F);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet Outsheet = workbook.createSheet("sample"); // to create a new sheet in the workbook named as sample
		Row Outrow = Outsheet.createRow(0); // to create a new rwo in the workbook
		for (int i=0;i<totalValue;i++) // used to create a multiple column (cell) from the 0th row
		{
			Cell Outcell = Outrow.createCell(i); // to create a new column in the workbook
			Outcell.setCellValue(name[i]); // giving the value to the cell using String[] name array i
		}
		
		workbook.write(FS); // write command to write the giving values in the workbook
		workbook.close(); // closing the workbook
		}
	
	public void writedata_with_multiplevalue_inrow() throws IOException {
		String[] name = {"Maha", "26", "java"};
		int totalValue = name.length; // it will read the count to create a row and column
		File F = new File(filePath+fileName);
		FileOutputStream FS = new FileOutputStream(F);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet Outsheet = workbook.createSheet("sample"); // to create a new sheet in the workbook named as sample
		for (int i=0;i<totalValue;i++) // used to create a multiple column (cell) from the 0th row
		{
			Row Outrow = Outsheet.createRow(i); // to create a new rwo in the workbook
			Cell Outcell = Outrow.createCell(0); // to create a new column in the workbook
			Outcell.setCellValue(name[i]); // giving the value to the cell using String[] name array i
		}
		
		workbook.write(FS); // write command to write the giving values in the workbook
		workbook.close(); // closing the workbook
		}
	
	public void writedata_with_multiplevalue_in3rdrow() throws IOException {
		String[] name = {"Maha", "26", "java"};
		int totalValue = name.length; // it will read the count to create a row and column
		File F = new File(filePath+fileName);
		FileOutputStream FS = new FileOutputStream(F);
		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet Outsheet = workbook.createSheet("sample"); // to create a new sheet in the workbook named as sample
		Row Outrow = Outsheet.createRow(2); // to create a new rwo in the workbook
		for (int i=0;i<totalValue;i++) // used to create a multiple column (cell) from the 0th row
		{
			
			Cell Outcell = Outrow.createCell(i); // to create a new column in the workbook
			Outcell.setCellValue(name[i]); // giving the value to the cell using String[] name array i
		}
		
		workbook.write(FS); // write command to write the giving values in the workbook
		workbook.close(); // closing the workbook
		}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Excelfilehandling_writedata S = new Excelfilehandling_writedata();
		S.writedata_with_multiplevalue_in3rdrow();

	}

}
