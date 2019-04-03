package Selenium.CAB_Movesync;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.*;


public class Launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\CAB_Movesync\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://dxc.moveinsync.com/DChe/employee.jsp#EmployeeLogin");
		
		/*System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CAB_Movesync\\Driver\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		
		driver1.get("https://dxc.moveinsync.com/DChe/employee.jsp#EmployeeLogin");*/
		
		File scr =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scr, new File("Logo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
