package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils_Framework.ExcelFileHandling;

public class DataProviderClass {
	@DataProvider
	public Object[][] searchdata() throws IOException // this method is used to read the data in the excel file
	{
		ExcelFileHandling s = new ExcelFileHandling();
		return s.ExcelReaddata("MakeMyTrip.xls", "Text");
		
	}
	@DataProvider
	public Object[][] searchdatawithinvalid() throws IOException // this method is used to read the data in the excel file
	{
		ExcelFileHandling s = new ExcelFileHandling();
		return s.ExcelReaddata("Invaliddata.xls", "Sheet1");
		
	}
}
