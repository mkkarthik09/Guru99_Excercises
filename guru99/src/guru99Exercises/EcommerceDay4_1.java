package guru99Exercises;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EcommerceDay4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	 // 1. go to page
		System.setProperty("webdriver.gecko.driver","D:\\QA Tools\\Selenium\\drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://live.guru99.com/index.php/");
				
		//2. Click Mobile link
		WebElement mobileslink=driver.findElement(By.linkText("MOBILE"));
		mobileslink.click();
		
		// Sort mobile list by Name
		Select sortdrp=new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		sortdrp.selectByVisibleText("Name");
		
		//Scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		//3. In mobile product list, Click on 'Add To Compare ' for 2 mobile
		WebElement samsunggalaxyaddtocompare=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a"));
		samsunggalaxyaddtocompare.click();
		
		WebElement sonyxperiaaddtocompare=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
		sonyxperiaaddtocompare.click();
		
		//4. Click on compare button
		
		String handle1= driver.getWindowHandle();
		System.out.println(handle1);
		
		WebElement comparebutton=driver.findElement(By.cssSelector("button.button[title='Compare']"));
		comparebutton.click();
		
		//5. Verify the pop-up window and check that the products are reflected in it
		for(String handle2 : driver.getWindowHandles()){
		    driver.switchTo().window(handle2);
		}
		
		
		driver.manage().window().maximize();
		String newtitle=driver.findElement(By.tagName("h1")).getText();
		System.out.println(newtitle);
		
		// Take screenshot of the new window
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("D:\\QA Tools\\screenshots\\Comparewindow.jpg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Closing active current window
			driver.close();
			
		// Switch back to original browser (first window)
		driver.switchTo().window(handle1);
		
	}

}
