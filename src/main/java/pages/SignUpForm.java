package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpForm {

    private final WebDriver driver;
    public SignUpForm(WebDriver driver){
        this.driver=driver;
    }

    private final By assertElement = By.className("page-subheading");
    private final By genderBtn = By.id("id_gender1");
    private final By firstNameField = By.id("customer_firstname");
    private final By lastNameField = By.id("customer_lastname");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("passwd");
    private final By selectDaysField= By.id("days");
    private final By selectMonthsField= By.id("months");
    private final By selectYearsField= By.id("years");
    private final By checkbox = By.id("newsletter");
    private final By submitBtn = By.id("submitAccount");
    private final By assertErrorMessage = By.className("alert-danger");

    public  By getAssertElement(){
        return assertElement;
    }

    public SignUpForm fillUpSignUpForm(String firstName, String lastName, String email , String password, int selectDay, int selectMonth, int selectYear){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(genderBtn)).click();
        }
        catch (Exception e){
            System.out.println("Exception occurred while waiting for gender button: "+ e.getMessage());
        }
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        if(driver.findElement(emailField).getAttribute("value").isBlank()){
            driver.findElement(emailField).sendKeys(email);
        }
        driver.findElement(passwordField).sendKeys(password);

        // Select dropdown options after ensuring the dropdown is clickable
        Select selectDays = new Select(driver.findElement(selectDaysField));
        Select selectMonths = new Select(driver.findElement(selectMonthsField));
        Select selectYears = new Select(driver.findElement(selectYearsField));
        selectDays.selectByIndex(selectDay);
        selectMonths.selectByIndex(selectMonth);
        selectYears.selectByIndex(selectYear);
        // Click the checkbox & submit btn to submit the form
        driver.findElement(checkbox).click();
        driver.findElement(submitBtn).click();

        return this;
    }

    public boolean verifySignedUpSuccessfully(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        return driver.findElement(myAccountPage.getAssertElement()).isDisplayed();
    }
    public boolean verifyErrorMessageDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertErrorMessage))).isDisplayed();
    }
}
