package com.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.config.Path;

public class PropertiesFile 
{
	public String ReadPropertyFileContents(String key) throws FileNotFoundException
	{
		FileInputStream pf1 = new FileInputStream(Path.prop);		
		Properties pr = new Properties();
		
		String value = pr.getProperty(key);
		
		return value;
	}

}
