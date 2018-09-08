package guru99Exercises;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerce_Day9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.navigate().to("http://live.guru99.com/index.php/");
		
		WebElement ACCOUNT=driver.findElement(By.linkText("ACCOUNT"));
		ACCOUNT.click();
		
		WebElement MYACCOUNT=driver.findElement(By.linkText("My Account"));
		MYACCOUNT.click();
		
		WebElement EMAIL=driver.findElement(By.id("email"));
		EMAIL.clear();
		EMAIL.sendKeys("mk.karthik09@gmail.com");
		
		WebElement PASSWORD=driver.findElement(By.id("pass"));
		PASSWORD.clear();
		PASSWORD.sendKeys("Whatever5833");
		
		WebElement LOGIN=driver.findElement(By.id("send2"));
		LOGIN.click();
		
		WebElement MOBILE=driver.findElement(By.linkText("MOBILE"));
		MOBILE.click();
		
		WebElement IPHONE=driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button"));
		IPHONE.click();
		
		WebElement BEFORE_GRANDTOTAL=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"));
		String grandtotal_1=BEFORE_GRANDTOTAL.getText();
		double intValue = Double.parseDouble(grandtotal_1.replaceAll("[^0-9\\.]+", ""));
		System.out.println("Grand total before discount= "+intValue);
		
		WebElement DISCOUNTCODE=driver.findElement(By.id("coupon_code"));
		DISCOUNTCODE.clear();
		DISCOUNTCODE.sendKeys("GURU50");
		
		
		WebElement APPLY=driver.findElement(By.cssSelector("button.button2[title='Apply']"));
		APPLY.click();
		
		WebElement discountamount=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span"));
		String DISCOUNTAMOUNT1=discountamount.getText();
		double intValue1 = Double.parseDouble(DISCOUNTAMOUNT1.replaceAll("[^0-9\\.]+", ""));
		System.out.println("Discount Amount= "+intValue1);
		
		
		/*double intValue3=(5*(intValue))/100;
		System.out.println("Calculated intValue3= "+intValue3);
		*/
		
		if (intValue1==((5*(intValue))/100)){
			System.out.println("Discount has applied successfully");
		}
		else{
			System.out.println("Discount hasn't applied");
		}
		
		
		/*WebElement AFTER_GRANDTOTAL=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"));
		String grandtota2_1=AFTER_GRANDTOTAL.getText();
		double intValue1 = Double.parseDouble(grandtota2_1.replaceAll("[^0-9\\.]+", ""));
		System.out.println("Grand total after discount= "+intValue1);
		
		if (intValue1==((intValue)-5%(intValue))){
			System.out.println("Discount has applied successfully");
		}
		else{
			System.out.println("Discount hasn't applied");
		}
		*/
		
		
		
		
		
		}
		
		
		
		
		
	}	


