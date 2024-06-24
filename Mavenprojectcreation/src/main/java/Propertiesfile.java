import java.io.*;
import java.util.Properties;
public class Propertiesfile {
	String filePath = "C:\\Users\\WIN\\eclipse-workspace\\Mavenprojectcreation\\src\\main\\java\\textfolder\\";
	String fileName = "file.properties";
	
	public void getvalue_propertyfile() throws IOException
	{
		File F = new File(filePath+fileName);
		FileInputStream FS = new FileInputStream(F);
		Properties Ps = new Properties(); // propert method
		Ps.load(FS); // load is used to read the FS file to readable format
		System.out.println(Ps.getProperty("name"));
		System.out.println(Ps.getProperty("role"));	
		System.out.println(Ps.getProperty("key"));	
		Ps.setProperty("wife", "Maha"); // adding values and key in the property file but it is not displayed in the property file
		System.out.println(Ps.getProperty("wife"));
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Propertiesfile S = new Propertiesfile();
		S.getvalue_propertyfile();

	}

}
