package tests.UI;

import org.testng.annotations.Test;
import pages.SignInPage;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PhysicianAppointment_UI {

    //user (doctor) can see their appointments list and time slots on My Appointments

    UserPage  userPage =new UserPage();

    public void adminLogin() {
        SignInPage signInPage=new SignInPage();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaLoginUrl"));
        ReusableMethods.waitAndSendText(signInPage.usernameLoginBox,"doktorPascal");
        ReusableMethods.waitAndSendText(signInPage.passwordLoginBox,"Dkt@1617");
        signInPage.LoginSignInButton.click();

    }

    @Test
    public void testAppointment() {
        adminLogin();

        userPage.mYPAGESButton.click();
        userPage.myAppointmentsButton.click();
        assert userPage.appointment_headingText.isDisplayed();
        Driver.closeDriver();
    }

    @Test
    public void testTimeSlots() {

        adminLogin();

        userPage.mYPAGESButton.click();
        userPage.myAppointmentsButton.click();
        assert userPage.jh_card_cardTextTable.isDisplayed();
        Driver.closeDriver();

    }
}
