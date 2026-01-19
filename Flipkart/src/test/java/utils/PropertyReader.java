package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {
	public static Properties readProperty() {
		String fileName = "/Flipkart/src/test/resources/config/config.properties";
		FileInputStream fis;
		Properties prop = null;
		
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			System.out.println("There is no properties file");
			fnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}