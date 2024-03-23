package test.testdemo;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class dataproviderAnnotation {
  @Test(dataProvider = "testdata")
  public void login_logouttest(String uname, String pass) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\testing\\automationtesting\\driverresource\\chromedriver.exe");	
		WebDriver d=new ChromeDriver();
		//implicite wait is used to
		d.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		d.get("https://www.saucedemo.com/v1/index.html");
		d.findElement(By.id("user-name")).sendKeys(uname);
		d.findElement(By.name("password")).sendKeys(pass);
		d.findElement(By.id("login-button")).click();
		d.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		d.findElement(By.linkText("Logout")).click();
		d.close();	
  }
  @DataProvider
  public Object[][] testdata() {
    return new Object[][] {
      new Object[] { "standard_user", "secret_sauce" },
      new Object[] {"problem_user", "secret_sauce" },
    };
  }
}
