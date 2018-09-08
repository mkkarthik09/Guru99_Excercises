package guru99Exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerce_Day8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.navigate().to("http://live.guru99.com/");
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
		
		WebElement reorder=driver.findElement(By.xpath("//*[@id='my-orders-table']/tbody/tr[1]/td[6]/span/a[2]"));
		reorder.click();
		
		WebElement qty=driver.findElement(By.cssSelector("input.input-text.qty[title='Qty']"));
		qty.clear();
		qty.sendKeys("2");
		
		WebElement updatecart=driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button/span/span"));
		updatecart.click();
		
		WebElement actualprice=driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[3]/span/span"));
		String productprice=actualprice.getText();
		double numericactualprice = Double.parseDouble(productprice.replaceAll("[^0-9\\.]+", ""));
		System.out.println("Actual single peice price is "+numericactualprice);
		
		WebElement grandtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"));
		String grandtotalstr=grandtotal.getText();
		double numericgrandtotal = Double.parseDouble(grandtotalstr.replaceAll("[^0-9\\.]+", ""));
		System.out.println("Grand total is "+numericgrandtotal);
		
		if (numericgrandtotal==numericactualprice*2){
			System.out.println( "Grand total calculation is correct and verified");
					}
		else{
			System.out.println( "Grand total calculation is not correct");
		}
		
		WebElement proceedtocheckout=driver.findElement(By.cssSelector("button.button.btn-proceed-checkout.btn-checkout[title='Proceed to Checkout']"));
		proceedtocheckout.click();
		
		
		
		WebElement Continue_billinginfo=driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button"));
		Continue_billinginfo.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement Continue_shippingmethod=driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/button/span/span"));
		Continue_shippingmethod.click();
		
		WebElement Check_Moneyorder=driver.findElement(By.id("p_method_checkmo"));
		Check_Moneyorder.click();
		
		WebElement Continue_paymentinfo=driver.findElement(By.xpath("//*[@id='payment-buttons-container']/button/span/span"));
		Continue_paymentinfo.click();
		
		WebElement placeorder=driver.findElement(By.xpath("//*[@id='review-buttons-container']/button"));
		placeorder.click();
		
		WebElement orderid=driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/p[1]"));
		String printorderid=orderid.getText();
		System.out.println("Order ID is "+printorderid);
	
	
	
	
	}
	
	
	
	
	
	

}
