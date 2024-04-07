package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class BaseClass {
	protected static WebDriver wd;
	protected static String strCombinedURL = "";
	String strPropDetails = "";

	/*
	public String getProperty(String strProp) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\mmallik\\eclipse-workspace\\Web_KSRTC_DataProvider\\src\\DataProvider\\KSRTC.properties");
		prop.load(fis);
		strPropDetails = prop.getProperty(strProp);
		
		return strPropDetails;
	}
	
	public String getCombinedURL() throws IOException {
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream("C:\\Users\\mmallik\\eclipse-workspace\\Web_KSRTC_DataProvider\\src\\DataProvider\\KSRTC.properties");
//		prop.load(fis);
//		String strProtocol = prop.getProperty("Protocol");
//		String strURL= prop.getProperty("URL");
//		String strPath = prop.getProperty("Path");
//		String strUN = prop.getProperty("UserName");
//		String strPassword = prop.getProperty("Password");
//		strCombinedURL = strProtocol + "://" + strURL + "/" + strPath;
		
		strCombinedURL = getProperty("Protocol") + "://" + getProperty("URL") + "/" + getProperty("Path");

		return strCombinedURL;
	}
	*/
	
	public static void initBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Mallik\\Selenium\\Jars\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
	}
	
	public static void destroyBrowser() {
		
		wd.close();
	}
	
	public static void captureScreenshot(String strFileName) throws IOException {
		File screenshotAs = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
//		Files.copy(screenshotAs, new File("C:\\Mallik\\"+strFileName+".png"));
		Files.copy(screenshotAs, new File(System.getProperty("user.dir")+"\\src\\DataProvider\\"+strFileName+".png"));
	}

}
