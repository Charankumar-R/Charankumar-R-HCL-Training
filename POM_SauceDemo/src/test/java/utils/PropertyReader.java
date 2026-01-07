package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {

	public static Properties readProperty() {
		
		String fileName = "/POM_SauceDemo/src/test/resources/config/config.properties";
		FileInputStream fis;
		Properties prop = null;
		
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
					
		}catch(FileNotFoundException fe) {
			IO.println("There is no properties file found");
			fe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
