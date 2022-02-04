package com.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.config.Path;

public class PropertiesFile  
{
	public static String ReadPropertyFileContents(String key) throws IOException
	{
		FileInputStream pf1 = new FileInputStream(Path.prop);
		
		Properties pr = new Properties();
		
		pr.load(pf1);
		
		String value = pr.getProperty(key);
		
		return value;
	}

}
