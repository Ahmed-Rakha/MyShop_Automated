package testCases;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpForm;

public class TestSignUpForm extends BaseTest{

    Faker faker = new Faker();
    String validEmail;
    int selectDay;
    int selectMonth;
    int selectYear;

//    Test Data
    @DataProvider (name ="validateRequiredField")
    public Object[][] testRequiredFields(){
        return new Object[][]{
                {"Ahmed","Rakha","adada",true}, // form submitted successfully
                {"","Rakha","adada",false}, // form is not submitted successfully
                {" ","Rakha","adada",false},// there is a bug in this statement. The form can be submitted if we put space in the field
                {"Ahmed","","adada",false},
                {"Ahmed","Rakha","",false},

        };
    }

    // Test signing up after filling all the fields with required correct data and another with omitting some required fields
    @Test(dataProvider = "validateRequiredField")
    public void testSignUpForm(String firstName, String lastName,String password, boolean expectedResult){
        selectDay = faker.number().numberBetween(0,30);
        selectMonth= faker.number().numberBetween(0,11);
        selectYear= faker.number().numberBetween(0,50);
        validEmail = faker.internet().emailAddress();

        SignUpForm signUpForm = new LoginPage(driver)
                .login()
                .navigateToSignUpForm(faker.internet().emailAddress());

        if (expectedResult){
            Assert.assertTrue(signUpForm.fillUpSignUpForm(firstName,lastName,validEmail,password,selectDay,selectMonth,selectYear)
                    .verifySignedUpSuccessfully(),"is  submitted successfully");
        }
        else {
            Assert.assertTrue(
                    signUpForm.fillUpSignUpForm(firstName,lastName,validEmail,password,selectDay,selectMonth,selectYear)
                            .verifyErrorMessageDisplayed(),"is not submitted successfully"
            );
        }
    }
}


