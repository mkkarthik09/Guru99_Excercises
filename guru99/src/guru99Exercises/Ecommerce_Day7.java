package guru99Exercises;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ecommerce_Day7 {

	public static void main(String[] args) throws AWTException {
				
		System.setProperty("webdriver.gecko.driver","D:\\QA Tools\\Selenium\\drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://live.guru99.com/");
		
		WebElement account= driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/a/span[2]"));
		account.click();
		
		WebElement myaccount= driver.findElement(By.linkText("My Account"));
		myaccount.click();
		
		WebElement emailaddress=driver.findElement(By.id("email"));
		emailaddress.clear();
		emailaddress.sendKeys("mk.karthik09@gmail.com");
		
		WebElement password=driver.findElement(By.id("pass"));
		password.clear();
		password.sendKeys("Whatever5833");
		
		WebElement login=driver.findElement(By.id("send2"));
		login.click();
		
		WebElement myorders=driver.findElement(By.linkText("MY ORDERS"));
		myorders.click();
		
		WebElement vieworder=driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr[1]/td[6]/span/a[1]"));
		vieworder.click();
		
		String orderid=driver.getTitle();
		System.out.println("Order id is "+orderid);
		
		WebElement printorder1=driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]"));
		printorder1.click();
		
		StringSelection ss = new StringSelection("D:\\QA Tools\\Selenium\\screenshots");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //copy the above string to clip board     
        Robot robot;
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000); 
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL); //paste the copied string into the dialog box
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER); //enter 
		
						
		
		          }

		
	}

