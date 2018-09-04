package guru99Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyHomepage extends VerifyLogin{

	@Test (priority=0)
	public void verifyHomepage(){
		
		
		if (driver.getTitle().contains("HomePage")){
			System.out.println("Page title contains \"HomePage\" ");
			WebElement logout= driver.findElement(By.linkText("Log out"));
			logout.click();
			driver.switchTo().alert().accept();
		}
		else {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		};
		
		//driver.quit();
		
	}
	}
