package guru99Exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ecommerce_Day5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*1. Go to URL
		 *2. Click my account link
		 *3. Click create account link and fill new user information except email id
		 *4. Click Register
		 *5. Verify registration is done
		 *6. Go to TV menu
		 *7. Add product in your wishlist(Product LG LCD)
		 *8. Click share wishlist
		 *9. In the next page enter the email and a message and click share wishlist
		 *10. Check wishlist is shared   
		 * 
		 */
		
		//1. Go to URL
		
		System.setProperty("webdriver.gecko.driver","D:\\QA Tools\\Selenium\\drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
				
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://live.guru99.com/index.php/");
		
		//2. Click my account link
		
		WebElement Account=driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]"));
		Account.click();
		
		WebElement MyAccount=driver.findElement(By.linkText("My Account"));
		MyAccount.click();
		
		//3. Click create account link and fill new user information except email id
		
		WebElement CreateAccount=driver.findElement(By.linkText("CREATE AN ACCOUNT"));
		CreateAccount.click();
		
		WebElement FirstName=driver.findElement(By.id("firstname"));
		FirstName.clear();
		FirstName.sendKeys("Karthik");
		
		WebElement MiddleName=driver.findElement(By.id("middlename"));
		MiddleName.clear();
		MiddleName.sendKeys("Muthaiya");
		
		WebElement LastName=driver.findElement(By.id("lastname"));
		LastName.clear();
		LastName.sendKeys("Karuppiah");
		
		WebElement EmailAddress=driver.findElement(By.id("email_address"));
		EmailAddress.clear();
		EmailAddress.sendKeys("mk.karthik2727@gmail.com");
		
		WebElement Password=driver.findElement(By.id("password"));
		Password.clear();
		Password.sendKeys("Whatever5833");
		
		WebElement ComfirmPassword=driver.findElement(By.id("confirmation"));
		ComfirmPassword.clear();
		ComfirmPassword.sendKeys("Whatever5833");
		
		//4. Click Register
		
		WebElement Registerbutton=driver.findElement(By.cssSelector("button.button[title='Register']"));
		Registerbutton.click();
		
		String WindowTitle=driver.getTitle();
		
		if(WindowTitle.contains("Create New Customer Account")){
			System.out.println("New Account has not created");
		}
		else
		{
			System.out.println("New Account has created successfully");
		}
			
			/*
		  6. Go to TV menu
		 *7. Add product in your wishlist(Product LG LCD)
		 *8. Click share wishlist
		 *9. In the next page enter the email and a message and click share wishlist
		 *10. Check wishlist is shared  
			*/
			
		//6. Go to TV menu
		WebElement TV=driver.findElement(By.linkText("TV"));
		TV.click();
		
		//Scroll down
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
				
		//7. Add product in your wishlist(Product LG LCD)
		WebElement LGLCD=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
		LGLCD.click();
		
		//8. Click share wishlist
		
		WebElement ShareWishlist=driver.findElement(By.cssSelector("button.button[title='Share Wishlist']"));
		ShareWishlist.click();
		
		WebElement EmailID=driver.findElement(By.id("email_address"));
		EmailID.clear();
		EmailID.sendKeys("mk.karthik09@gmail.com,kovil.karthik@gmail.com");
		
		//Scroll down
				JavascriptExecutor jse1 = (JavascriptExecutor)driver;
				jse1.executeScript("window.scrollBy(0,250)", "");
		
		WebElement Message=driver.findElement(By.id("message"));
		Message.clear();
		Message.sendKeys("Test");
		
		
		WebElement ShareWishlist1=driver.findElement(By.cssSelector("button.button[title='Share Wishlist']"));
		ShareWishlist1.click();
		
		// 10. Check wishlist is shared  
		String	WishListShared=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
		System.out.println(WishListShared);
			
						
	}

}
