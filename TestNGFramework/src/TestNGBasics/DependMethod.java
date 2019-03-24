package TestNGBasics;

import org.testng.annotations.Test;

public class DependMethod {
@Test
public void login() {
	System.out.println("loginpage");
	int i =9/0;
}
@Test(dependsOnMethods="login")
public void Homepage() {
	System.out.println("home page");
}
@Test(dependsOnMethods="login")
public void search() {
	System.out.println("search page");
}
}
