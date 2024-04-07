package Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Generic.BaseClass;

public class Login_Test extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Mallik\\Selenium\\Jars\\chromedriver.exe");
//		WebDriver wd = new ChromeDriver();
//		wd.manage().window().maximize();
//		wd.get("https://ksrtc.in/oprs-web/login/show.do");
		
		initBrowser();
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\mruty\\eclipse-workspace\\Web_KSRTC_DataProvider\\src\\DataProvider\\KSRTC.properties");
		prop.load(fis);
		String strProtocol = prop.getProperty("Protocol");
		String strURL= prop.getProperty("URL");
		String strPath = prop.getProperty("Path");
		strCombinedURL = strProtocol + "://" + strURL + "/" + strPath;
		
		wd.get(strCombinedURL);
		captureScreenshot("test1");
		//ajit.badakar@gmail.com/ksrtc@1234
//		wd.findElement(By.id("userName")).sendKeys("ajit.badakar@gmail.com");
//		wd.findElement(By.cssSelector("input#password")).sendKeys("ksrtc@1234");
		String strUN = prop.getProperty("UserName");
		String strPassword = prop.getProperty("Password");
		wd.findElement(By.id("userName")).sendKeys(strUN);
		wd.findElement(By.cssSelector("input#password")).sendKeys(strPassword);
//		wd.findElement(By.cssSelector("label.custom-control-label::before")).click();
//		wd.findElement(By.xpath("//div/input[@type='checkbox']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) wd;
		WebElement link = wd.findElement(By.xpath("//*[@id='TermsConditions']"));
		js.executeScript("arguments[0].click();", link);

//		String script = "return window.getComputedStyle(document.querySelector('label.custom-control-label'),':before').getPropertyValue('content')";
//		System.out.println(script);
//		Thread.sleep(3000);
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        String content = (String) js.executeScript(script);
//        System.out.println(content);
//        window.getComputedStyle(document.querySelector('label.custom-control-label'),':after').
        
//		wd.findElement(By.xpath("//input[@id='submitBtn']")).click();

		Thread.sleep(5000);
		captureScreenshot("test2");
		destroyBrowser();
	}

}
