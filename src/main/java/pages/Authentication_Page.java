package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Authentication_Page {

    private final WebDriver driver;
    public Authentication_Page(WebDriver driver){
        this.driver= driver;
    }
    private By assertElement = By.xpath("//h1[text()=\"Authentication\"]");
    private By createEmailField = By.id("email_create");
    private By createAccountBtn = By.id("SubmitCreate");
    private By errorMessage = By.id("create_account_error");
    public By getAssertElement(){
        return assertElement;
    }
public By getErrorMessage(){
        return errorMessage;
}
    public Authentication_Page checkEmailPattern(String email){
        driver.findElement(createEmailField).sendKeys(email);
        driver.findElement(createAccountBtn).click();
        return this;
    }

    public SignUpForm navigateToSignUpForm(String validEmail){
        driver.findElement(createEmailField).sendKeys(validEmail);
        driver.findElement(createAccountBtn).click();
        return new SignUpForm(driver);
    }
    //    check if the email pattern entered correctly

    public  boolean verifyValidEmailEntered(){
        SignUpForm signUpForm = new SignUpForm(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(signUpForm.getAssertElement()))).isDisplayed();

    }
    public boolean verifyInvalidEmailEntered(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorMessage))).isDisplayed();
    }
}
