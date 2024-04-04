package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;
    public  MyAccountPage(WebDriver driver){
        this.driver = driver;
    }

    private final By assertElement = By.xpath("//h1[text()=\"My account\"]");

    public By getAssertElement(){
        return assertElement;
    }
}
