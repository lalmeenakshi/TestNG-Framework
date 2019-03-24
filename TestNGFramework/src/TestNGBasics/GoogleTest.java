package TestNGBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Kumar\\Downloads\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     driver.get("https://www.google.com/");
	}
	@Test(priority=1,groups="title")
	public void title() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=3,groups="logo")
	public void logo() {
		boolean a = driver.findElement(By.xpath("/html/body/div/div[6]/span/center/div[1]/div/a/img")).isDisplayed();
		Assert.assertEquals(a, true);
	}
	@Test(priority=2,groups="links")
	public void maillink() {
		boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
		//Assert.assertEquals(b, true);
		Assert.assertTrue(b);
	}
@AfterMethod
public void teardown() {
	driver.quit();
}
}
