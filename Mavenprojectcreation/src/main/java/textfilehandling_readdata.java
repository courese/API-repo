
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class textfilehandling_readdata {
	String filePath ="C:\\Users\\WIN\\eclipse-workspace\\Mavenprojectcreation\\src\\main\\java\\textfolder\\";
	String fileName ="newtext.txt";
	
	public void readdata() throws IOException {
		File F = new File(filePath+fileName); //used to open the file
		FileInputStream FI = new FileInputStream(F); //reading a file
		System.out.println((char)FI.read()); //to convert the byte into character -char is used
		int i = 0;
		while ((i=FI.read())!=-1) // it is used to print all the data in the text file
		{
			System.out.print((char)i);
		}
	}
	public void readdatalinebyline() throws IOException {
		File F = new File(filePath+fileName); //used to open the file
		FileReader FI = new FileReader(F); //FileReader is used to read a text file character by character
		int i = 0;
		while ((i=FI.read())!=-1) // it is used to print all the data in the text file
		{
			System.out.println((char)i);
		}
	}
	public void readdatalinebylineusing_buffered() throws IOException {
		File F = new File(filePath+fileName); //used to open the file
		FileReader FI = new FileReader(F); //reading a file
		BufferedReader BF = new BufferedReader(FI); // buffered method is used to read the text file line by line
		String i = null;
		while ((i=BF.readLine())!=null) // it is used to print all the data in the text file
		{
			System.out.println(i);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		textfilehandling_readdata sample = new textfilehandling_readdata();
		sample.readdatalinebylineusing_buffered();

	}

}
