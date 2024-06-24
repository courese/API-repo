
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileWriter;
import java.io.BufferedReader;

public class Textfilehandling_writedata {
	String outputfilePath ="C:\\Users\\WIN\\eclipse-workspace\\Mavenprojectcreation\\src\\main\\java\\textfolder\\";
	String outputfileName ="outnewtext.txt";
	
	String outputString = "practicing read file handling methods";
	public void Writedata() throws IOException
	{
		File F = new File(outputfilePath+outputfileName); //used to open the file
		FileOutputStream FO = new FileOutputStream(F);
		FO.write(outputString.getBytes()); //getBytes are used to convert into number(bytes)
		FO.close(); // if not give close cmd then not able to see the wriiten data in the file
		System.out.println("done");
	}
	
	public void WritedataFileWriter() throws IOException
	{
		File F = new File(outputfilePath+outputfileName); //used to open the file
		FileWriter FO = new FileWriter(F);
		FO.write(outputString); //getBytes are not used here. FileWriter is an another method to write data without using getbyte
		FO.close(); // if not give close cmd then not able to see the wriiten data in the file
		System.out.println("done");
	}
	
	public void Writedatafrom_onefile_to_anotherfile() throws IOException
	{
		String filePath ="C:\\Users\\WIN\\eclipse-workspace\\Selenium Java tutorial\\src\\textfolder\\";
		String fileName ="newtext.txt";
		File F = new File(filePath+fileName); //used to open the file
		FileReader FI = new FileReader(F); //FileReader is used to read a text file character by character
		File FW = new File(outputfilePath+outputfileName); //used to open the file
		FileWriter FO = new FileWriter(FW);
		BufferedReader BF = new BufferedReader(FI);
		String i = null;
		while ((i=BF.readLine())!=null) // it is used to print all the data in the text file
		{
			FO.write(i);
		}

		
		FO.write(outputString); //getBytes are not used here. FileWriter is an another method to write data without using getbyte
		FO.close(); // if not give close cmd then not able to see the wriiten data in the file
		System.out.println("done");
	}



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Textfilehandling_writedata sample = new Textfilehandling_writedata();
		sample.Writedatafrom_onefile_to_anotherfile();
		
	}

}
