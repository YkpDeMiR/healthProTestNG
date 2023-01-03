package tests.UI;

import org.testng.annotations.Test;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class ValidLogin {

    SignInPage signInPage =new SignInPage();

    @Test
    public void testPhysicianLogin() {
        //There should be a valid username and password validating the success message to login
        Driver.getDriver().get(ConfigReader.getProperty("medunnaLoginUrl"));
        ReusableMethods.waitAndSendText(signInPage.usernameLoginBox,"baran");
        signInPage.passwordLoginBox.clear();
        ReusableMethods.waitAndSendText(signInPage.passwordLoginBox,"12345");
        signInPage.LoginSignInButton.click();
        signInPage.userIcon.click();
       assert  signInPage.signoutButton.isDisplayed();
       Driver.closeDriver();
    }

    @Test
    public void testRememberMe() {
        //There should be a remember me option where user can always use their existing credentials
        Driver.getDriver().get(ConfigReader.getProperty("medunnaLoginUrl"));
        signInPage.rememberMeButton.click();
        if (signInPage.rememberMeButton.getAttribute("value").toString().equals("true")){
            signInPage.rememberMeButton.isEnabled();
        }
        Driver.closeDriver();
    }

    @Test
    public void testdidUforgetPassword() {
        //There should be a remember me option where user can always use their existing credentials
        Driver.getDriver().get(ConfigReader.getProperty("medunnaLoginUrl"));
        ReusableMethods.doubleClick(signInPage.forgetpasswordButton);
        signInPage.forgetpasswordButton.click();
        signInPage.Resetyourpasswordtext.isDisplayed();
        Driver.closeDriver();
    }

}
