package com.smartData.Config;
import com.smartData.BuisnessLogic.*;

public class Config {
//	public static WebDriver driver;
	public static Operations BLoperation = new Operations();
	public static HTMLReportGenerator Report = new HTMLReportGenerator();
	public static PropertiesFileReader Property = new PropertiesFileReader(System.getProperty("user.dir") + "//Properties//config.properties");
}
