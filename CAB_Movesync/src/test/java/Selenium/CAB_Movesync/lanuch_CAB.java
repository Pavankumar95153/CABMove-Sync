package Selenium.CAB_Movesync;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class lanuch_CAB {
	
	WebDriver driver1;
	@BeforeTest
	
	public void browser() {
		
	
	
	System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\CAB_Movesync\\Driver\\geckodriver.exe");
	 driver1 = new FirefoxDriver();
	driver1.get("https://dxc.moveinsync.com/DChe/employee.jsp#EmployeeLogin");
	driver1.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="DATAA")
	
		
		
		public void testdata( @Optional("ABV") String Userid,String Password) {
			
		WebElement a = driver1.findElement(By.xpath("//input[@id='username']"));
		a.sendKeys(Userid);
		
		WebElement b = driver1.findElement(By.xpath("//input[@name='j_password']"));
		b.sendKeys(Password);
		
		WebElement c = driver1.findElement(By.xpath("//input[@value='Login']"));
		c.click();
		
		File scr =((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		
		try {
			
		
		FileUtils.copyFile(scr,new File( "Error.jpg"));
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@DataProvider(name ="DATAA")
	public Object[][] testdata(){
		return new Object[][] {
		
		
		{"115234447", "Love@123"}
		
		
		};
		}
	@AfterTest
	public void stop() {
		driver1.quit();
	}
}

