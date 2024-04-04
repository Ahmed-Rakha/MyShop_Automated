package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    String website_URL = "http://www.automationpractice.pl/index.php";

    @BeforeMethod
    @Test
    public void setUp(){
        driver= new ChromeDriver();
        driver.navigate().to(website_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    @Test
    public void tearDown(){
        driver.quit();
    }
}
