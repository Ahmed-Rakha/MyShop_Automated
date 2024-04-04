package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

//    locate elements on login page

    private final By signInBtn = By.xpath("//a[@title=\"Log in to your customer account\"]");


    public Authentication_Page login(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
        return new Authentication_Page(driver);
    }

    public boolean verifyLogin(){
        Authentication_Page authenticationPage = new Authentication_Page(driver);
        return driver.findElement(authenticationPage.getAssertElement()).isDisplayed();
    }


}
