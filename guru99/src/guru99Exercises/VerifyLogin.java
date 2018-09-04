package guru99Exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class VerifyLogin {
	static WebDriver driver;
	@BeforeSuite
	public void verifyLogin(){
		// Go to site
		//enter username,password and click login
		
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		driver.get("http://www.demo.guru99.com/V4/");
		WebElement UserID=driver.findElement(By.name("uid"));
		UserID.sendKeys("mngr148233");
		
		
		WebElement Password=driver.findElement(By.name("password"));
		Password.sendKeys("atUzAbu");
		
		
		WebElement Login=driver.findElement(By.name("btnLogin"));
		Login.click();
		//String title=driver.getTitle();
		//System.out.println(title);
		
		
		
	}
}
