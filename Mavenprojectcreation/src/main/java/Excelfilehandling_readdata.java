import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfilehandling_readdata {
	String filePath = "C:\\Users\\WIN\\eclipse-workspace\\Selenium Java tutorial\\src\\textfolder\\";
	String fileName = "excelfile.xlsx";
	
	public void readdata() throws IOException {
		File F = new File(filePath+fileName); //to open the file
		FileInputStream FS = new FileInputStream(F); // to read the data use fileinputstream and it is used to read only text files 
														//coz it will read the file in the format of bytes
		XSSFWorkbook workbook = new XSSFWorkbook(FS); // to read the excel file in the format of cells
		Sheet sheet = workbook.getSheet("sheet1"); // to read the particular sheet
		int totalRows = sheet.getPhysicalNumberOfRows(); // it will display the total number of rows
		for(int i=0;i<totalRows;i++) // to read each and every rows
		{
			Row row = sheet.getRow(i); //  the rows will get executed
			int totalColumn = row.getLastCellNum(); //to read the total number of columns
			for(int j=0;j<totalColumn;j++) // iterate each and every column
			{
				Cell eachcell = row.getCell(j); //the cell is a class will get executed
				System.out.print(eachcell.getStringCellValue());
				System.out.print("\t");
				
			}
			System.out.println("");
		}
			
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Excelfilehandling_readdata S = new Excelfilehandling_readdata();
		S.readdata();

	}

}
