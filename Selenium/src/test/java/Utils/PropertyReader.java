package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	public static Properties readProperty() {
		
		String fileName = "src\\main\\resources\\config\\config.properties";
		FileInputStream fis;
		Properties prop = null;
		
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}

}
