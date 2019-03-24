package TestNGBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	@Test
	@Parameters({"url","username","password"})
	public void Logindetails(String url,String username,String password) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Kumar\\Downloads\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get(url);
		driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(username);
	    driver.findElement(By.id("pass")).clear();
	    driver.findElement(By.id("pass")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@value='Log In']")).submit();
	}

}
