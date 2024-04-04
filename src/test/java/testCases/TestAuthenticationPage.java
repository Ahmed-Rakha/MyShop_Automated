package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Authentication_Page;
import pages.LoginPage;

public class TestAuthenticationPage extends BaseTest{

    @DataProvider(name = "test-email-pattern")
    public Object[][] getEmailPattern(){
        return new Object[][]{
                {"ahmed@gmail.com",true},
                {"ahmed2@gmail.com",true},
                {"2ahmed@gmail.com",true},
                {"22@gm.co",true},
                {"ahmed.com",false},
                {"ahmed@com",false},
                {"ahmed@com.",false}
        };
    }

    @Test(dataProvider = "test-email-pattern")
    public void testEmailPattern(String email , boolean expectedResult){

        Authentication_Page authenticationPage = new LoginPage(driver)
                .login()
                .checkEmailPattern(email);
        if(expectedResult){
            Assert.assertTrue( authenticationPage.verifyValidEmailEntered());
        }
        else {
            Assert.assertTrue(( authenticationPage.verifyInvalidEmailEntered()));
        }
    }
}
