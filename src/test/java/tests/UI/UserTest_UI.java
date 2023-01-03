package tests.UI;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class UserTest_UI {

   //There should be user info being populated when navigating to user info "firstname, lastname, email and language"
        SignInPage signInPage = new SignInPage();

    @Test
    public void testUser() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaLoginUrl"));
        ReusableMethods.waitAndSendText(signInPage.usernameLoginBox,"baran");
        ReusableMethods.waitAndSendText(signInPage.passwordLoginBox,"12345");
        signInPage.LoginSignInButton.click();
        signInPage.admin_menuButton.click();
        signInPage.usermanagementButton.click();
        signInPage.createanewuserButton.click();
        ReusableMethods.waitAndSendText(signInPage.loginText,"alicano");
        ReusableMethods.waitAndSendText(signInPage.firstNameBox,"ali");
        ReusableMethods.waitAndSendText(signInPage.lastNameBox,"can");
        ReusableMethods.waitAndSendText(signInPage.emailBox,"alicano@gmail.com");
        ReusableMethods.waitAndSendText(signInPage.SSNBox,"878-78-8778");
        Select select = new Select(signInPage.ddmLanguage);
        select.selectByIndex(1);
        select=new Select(signInPage.ddmRole);
        select.selectByIndex(3);
        JSUtils.clickElementByJS(signInPage.saveButton);

    }
}
