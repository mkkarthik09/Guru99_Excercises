package guru99Exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ECommerce_Day6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\QA Tools\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
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
		
		WebElement mywishlist= driver.findElement(By.linkText("MY WISHLIST"));
		mywishlist.click();
		
		WebElement AddAllToCart=driver.findElement(By.cssSelector("button.button.btn-add[title='Add All to Cart']"));
		AddAllToCart.click();
		
		WebElement Countrydrpdown=driver.findElement(By.id("country"));
		Select CntryDrp=new Select(Countrydrpdown);
		CntryDrp.selectByVisibleText("United States");
		
		WebElement Regiondrpdown=driver.findElement(By.id("region_id"));
		Select RegDrp=new Select(Regiondrpdown);
		RegDrp.selectByVisibleText("New York");
		
		WebElement zip=driver.findElement(By.id("postcode"));
		zip.clear();
		zip.sendKeys("542896");
		
		WebElement estimate=driver.findElement(By.xpath("//*[@id='shipping-zip-form']/div/button"));
		estimate.click();
		
		WebElement shippingcost=driver.findElement(By.xpath("//*[@id='co-shipping-method-form']/dl/dd/ul/li/label/span"));
		String estimatedcost= shippingcost.getText();
		double estimatedamount = Double.parseDouble(estimatedcost.replaceAll("[^0-9\\.]+", ""));
		
		if (estimatedcost.equalsIgnoreCase("$5.00")){
			System.out.println("Estimated cost is "+estimatedcost);
		}
		else{
			System.out.println("Estimated cost is not matched with $5.00" );
		}
		
		WebElement flatrateradioselection=driver.findElement(By.id("s_method_flatrate_flatrate"));
		flatrateradioselection.click();
		
		WebElement updatetotal=driver.findElement(By.cssSelector("button.button[value='Update Total']"));
		updatetotal.click();
		
		WebElement subtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tbody/tr[1]/td[2]/span"));
		String subtotalfig= subtotal.getText();
		double subtotalamount = Double.parseDouble(subtotalfig.replaceAll("[^0-9\\.]+", ""));
		System.out.println(subtotalamount);
		
		WebElement grandtotal=driver.findElement(By.xpath("//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"));
		String grandtotalfig= grandtotal.getText();
		double grandtotalamount = Double.parseDouble(grandtotalfig.replaceAll("[^0-9\\.]+", ""));
		System.out.println(grandtotalamount);
		
		grandtotalamount=subtotalamount+estimatedamount;
		
		if (grandtotalamount==subtotalamount+estimatedamount){
			System.out.println("Estimated shipping amount has included in the grand total");
		}
		else{
			System.out.println("Estimated shipping amount has not included in the grand total");
		}
		
		
		WebElement ProceedToCheckOut=driver.findElement(By.cssSelector("button.button.btn-proceed-checkout.btn-checkout[title='Proceed to Checkout']"));
		ProceedToCheckOut.click();
		
		WebElement Continue=driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button/span/span"));
		Continue.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement Continue1=driver.findElement(By.xpath("//*[@id='shipping-method-buttons-container']/button"));
		Actions xAct = new Actions(driver);
		xAct.moveToElement(Continue1);
		xAct.click();
		xAct.perform();
		
		
		WebElement checkmoneyorder=driver.findElement(By.id("p_method_checkmo"));
		checkmoneyorder.click();
		
		WebElement Continue2=driver.findElement(By.xpath("//*[@id='payment-buttons-container']/button/span/span"));
		Actions xAct1 = new Actions(driver);
		xAct1.moveToElement(Continue2);
		xAct1.click();
		xAct1.perform();
		
		WebElement placeorder=driver.findElement(By.cssSelector("button.button.btn-checkout[title='Place Order']"));
		placeorder.click();
		
		WebElement orderid=driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/p[1]"));
		String printorderid=orderid.getText();
		System.out.println("Order ID id "+printorderid);
		
		driver.quit();
		
		
	}

}
