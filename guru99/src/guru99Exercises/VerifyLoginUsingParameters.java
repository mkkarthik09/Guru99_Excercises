package guru99Exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyLoginUsingParameters {
	WebDriver driver;
	@Test 
	@Parameters({"sUsername","sPassword"})
	public void test(String sUsername, String sPassword) {
		// TODO Auto-generated method stub
				
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("http://www.demo.guru99.com/V4/");
		WebElement UserID=driver.findElement(By.name("uid"));
		UserID.sendKeys(sUsername);
		
		
		WebElement Password=driver.findElement(By.name("password"));
		Password.sendKeys(sPassword);
		
		
		WebElement Login=driver.findElement(By.name("btnLogin"));
		Login.click();
		
		
	}

}
