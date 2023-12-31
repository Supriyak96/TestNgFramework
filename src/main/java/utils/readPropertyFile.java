package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertyFile {
	private readPropertyFile() {
	}

	public static String getValue(String key) throws IOException {
		Properties property = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/configFiles/config.properties");
		property.load(file);
		return property.getProperty(key);
	}
}
