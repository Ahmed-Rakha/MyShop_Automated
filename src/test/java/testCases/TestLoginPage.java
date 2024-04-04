package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SearchBrokenURLs;

public class TestLoginPage extends BaseTest{

    //    check if it is redirected to Authentication page after clicking Sign In

    @Test
    public void testLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        Assert.assertTrue(loginPage.verifyLogin());
    }

    //    check if there are broken URLs that need to be fixed
    @Test
    public void testBrokenUrls(){
        SearchBrokenURLs searchBrokenURLs  = new SearchBrokenURLs(driver);
        searchBrokenURLs.createListOfBrokenAnchors();
    }
}
