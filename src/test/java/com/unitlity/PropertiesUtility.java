package com.unitlity;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	public static String getData(String key) throws IOException {
		//create file class object
		File file = new File("D:\\Java\\seleniumtest\\src\\test\\resources\\testData.properties");
		// create file reader class object
		FileReader reader = new FileReader(file);
		// create properties class object
		Properties prop = new Properties();
		// load properties file 
		prop.load(reader);
		// call getValue() of the properties class
		return (String) prop.get(key);
	}

}
