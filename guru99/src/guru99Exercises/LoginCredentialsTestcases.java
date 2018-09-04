package guru99Exercises;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class LoginCredentialsTestcases extends VerifyLogin {
	
			/* 
		 * 1. Valid Credentials
		 * 2. Invalid userid, Valid password
		 * 3. Invalid password,valid userid
		 * 4. Invalid credentials
		 */
		
		//1. Valid Credentials
	
	@Test (priority=1)
	public void validCredetials(){
		driver.get("http://www.demo.guru99.com/V4/");
		WebElement UserID=driver.findElement(By.name("uid"));
		UserID.sendKeys("mngr148233");
		
		
		WebElement Password=driver.findElement(By.name("password"));
		Password.sendKeys("atUzAbu");
		
		
		WebElement Login=driver.findElement(By.name("btnLogin"));
		Login.click();
				
		
		if (driver.getTitle().contains("HomePage")){
			System.out.println("Page title contains \"HomePage\" ");
			
			WebElement mngrid = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td"));
			String actual_text = mngrid.getText();
			actual_text= actual_text.replace("Manger Id :"," ");
			System.out.println(actual_text);
			
			TakesScreenshot scrShot= ((TakesScreenshot)driver);
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
			
			File DstFile=new File("D:\\QA Tools\\Selenium\\screenshots\\Homepage.png");
			try {
				FileUtils.copyFile(srcFile,DstFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			WebElement logout= driver.findElement(By.linkText("Log out"));
			logout.click();
			driver.switchTo().alert().accept();
		}
		else {
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();}
		}
				
		//2. Invalid userid, Valid password
		@Test (priority=2)
		public void invalidUserID(){
			driver.get("http://www.demo.guru99.com/V4/");
			WebElement UserID=driver.findElement(By.name("uid"));
			UserID.sendKeys("mngr7676");
			
			
			WebElement Password=driver.findElement(By.name("password"));
			Password.sendKeys("atUzAbu");
			
			
			WebElement Login=driver.findElement(By.name("btnLogin"));
			Login.click();
			
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();	
		};
		
		 //3. Invalid password,valid userid
			
			@Test (priority=3)
			public void invalidPassword(){
				driver.get("http://www.demo.guru99.com/V4/");
				WebElement UserID=driver.findElement(By.name("uid"));
				UserID.sendKeys("mngr148233");
				
				
				WebElement Password=driver.findElement(By.name("password"));
				Password.sendKeys("12345");
				
				
				WebElement Login=driver.findElement(By.name("btnLogin"));
				Login.click();
								
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();	
				};
			
		
		 //4. Invalid credentials
				@Test (priority=4)
				public void invalidCredentials(){
					driver.get("http://www.demo.guru99.com/V4/");
					WebElement UserID=driver.findElement(By.name("uid"));
					UserID.sendKeys("mngr7676");
					
					
					WebElement Password=driver.findElement(By.name("password"));
					Password.sendKeys("12345");
					
					
					WebElement Login=driver.findElement(By.name("btnLogin"));
					Login.click();
					
					System.out.println(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();	
										};
	
					@AfterSuite
					public void quitBroswer(){
						driver.quit();}

					}



