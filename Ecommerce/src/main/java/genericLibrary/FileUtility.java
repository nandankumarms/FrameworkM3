package genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public static  String getProperty(String key) throws IOException {
		//Step 1: get the java representation of physical file
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata/commonData.properties");
	
		//Step 2:Create the object of Properties class
		Properties pObj=new Properties();
		
		//Stpe 3: Load all key and values to Properties object
		pObj.load(fis);
		
		//Step 4: Get the value using key
		return pObj.getProperty(key);		
	}
}
