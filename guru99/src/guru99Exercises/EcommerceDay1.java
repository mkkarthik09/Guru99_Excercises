package guru99Exercises;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class EcommerceDay1 {
	WebDriver driver;
	
	@BeforeSuite
	public void openBroswer(){
	System.setProperty("webdriver.gecko.driver","D:\\QA Tools\\Selenium\\drivers\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
	
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get("http://live.guru99.com/index.php/");
	}
	
	@Test (priority=0)
	public void day1(){
	String title= driver.findElement(By.cssSelector("h2")).getText();
	System.out.println(title);
		
		
	if(title.contains("THIS IS DEMO SITE FOR   ") ){
		System.out.println("Title has been successfully verified, Page title contains \"THIS IS DEMO SITE\" ");
	}
	else{
		System.out.println("Title hasn't been successfully verified, Page title does not contains \"THIS IS DEMO SITE\" ");
	};
	
	
	WebElement mobilelink=	driver.findElement(By.linkText("MOBILE"));
	mobilelink.click();
	
	String title1=driver.findElement(By.cssSelector("h1")).getText();
	System.out.println(title1);
	
	
	if(title1.contains("MOBILE") ){
		System.out.println("Title has been successfully verified, Page title contains \"MOBILE\" ");
	}
	else{
		System.out.println("Title hasn't been successfully verified, Page title does not contains \"MOBILE\" ");
	};
	
	Select sortdrp=new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
	sortdrp.selectByVisibleText("Name");
	
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile=new File("D:\\QA Tools\\screenshots\\SortbyName.jpg");
	try {
		FileUtils.copyFile(SrcFile, DestFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}
	
	@Test (priority=1)
	public void ecommerceDay2(){
		WebElement stockpriceText = driver.findElement(By.cssSelector("#product-price-1"));
		String price = stockpriceText.getText();
		System.out.println(price);
		
		WebElement sonyxperia=driver.findElement(By.linkText("SONY XPERIA"));
		sonyxperia.click();
		
		WebElement stockpriceText1 = driver.findElement(By.cssSelector(".price"));
		String price1 = stockpriceText1.getText();
		System.out.println(price1);
		
		if(price.equals(price1)){
			System.out.println("Price are same");
		}
		else{
			System.out.println("Price aren't same");
		}
				
	}
	
	@Test (priority=2)
	public void ecommerceDay3(){
		
		WebElement qty= driver.findElement(By.id("qty"));
		qty.sendKeys("1000");
		
		WebElement addtocart=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/div/div/div[2]/button"));
		addtocart.click();
		
		String errormsg=driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.catalog-product-view.product-sony-xperia.categorypath-mobile-html.category-mobile div.wrapper div.page div.main-container.col1-layout div.main div.col-main div#messages_product_view ul.messages li.error-msg li span")).getText();
		System.out.println(errormsg);
		
		driver.navigate().back();
		driver.navigate().back();
		
		WebElement addtocart1= driver.findElement(By.cssSelector("button.button.btn-cart"));
		addtocart1.click();
		
		WebElement emptycart=driver.findElement(By.id("empty_cart_button"));
		emptycart.click();
		
		String msg=driver.findElement(By.tagName("h1")).getText();
		System.out.println(msg);
				
	}
	
	@Test (priority=3)
	public void ecommerceDay4(){
		/*
		 1. go to page
		 http://live.guru99.com/index.php/
		 2. Click Mobile link
		 3. In mobile product list, Click on 'Add To Compare ' for 2 mobile
		 4. Click on compare button
		 5. Verify the pop-up window and check that the products are reflected in it
		 6. Close the pop-up windows
		 */
		
		 // 1. go to page
		WebElement homelink=driver.findElement(By.xpath("/html/body/div/div/header/div/a/img[1]"));
		homelink.click();
		
		
		//2. Click Mobile link
		WebElement mobileslink=driver.findElement(By.linkText("MOBILE"));
		mobileslink.click();
		
		//3. In mobile product list, Click on 'Add To Compare ' for 2 mobile
		WebElement samsunggalaxyaddtocompare=driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.catalog-category-view.categorypath-mobile-html.category-mobile div.wrapper div.page div.main-container.col3-layout div.main div.col-wrapper div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd li.item.last div.product-info div.actions ul.add-to-links li a.link-compare"));
		samsunggalaxyaddtocompare.click();
		
		WebElement sonyxperiaaddtocompare=driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.catalog-category-view.categorypath-mobile-html.category-mobile div.wrapper div.page div.main-container.col3-layout div.main div.col-wrapper div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd li.item.last div.product-info div.actions ul.add-to-links li a.link-compare"));
		sonyxperiaaddtocompare.click();
		
		//4. Click on compare button
		
		String handle= driver.getWindowHandle();
		System.out.println(handle);
		
		WebElement comparebutton=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/div[2]/div[2]/div/button"));
		comparebutton.click();
		
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		driver.switchTo().window(handle);
		driver.manage().window().maximize();
		String newtitle=driver.findElement(By.tagName("h1")).getText();
		System.out.println(newtitle);
		
		
		/*for (String handle1 : driver.getWindowHandles()) {
			 
        	System.out.println(handle1);      	
        	driver.manage().window().maximize();
    		String newtitle=driver.findElement(By.tagName("h1")).getText();
    		System.out.println(newtitle);

           	}*/
		//5. Verify the pop-up window and check that the products are reflected in it
		
		driver.close();
		 
		
		 
	}
	/*@AfterSuite
	public void closeBrowser(){
		//driver.quit();
	}*/
	}


