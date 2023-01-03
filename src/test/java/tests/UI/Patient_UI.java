package tests.UI;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PatientPage;
import pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Patient_UI {

    PatientPage patientPage=new PatientPage();

    @Test
    public void adminLogin() {
        SignInPage signInPage=new SignInPage();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaLoginUrl"));
        ReusableMethods.waitAndSendText(signInPage.usernameLoginBox,"baran");
        ReusableMethods.waitAndSendText(signInPage.passwordLoginBox,"12345");
        signInPage.LoginSignInButton.click();

    }

    @Test
    public void testPatient() {
        adminLogin();
        patientPage.ItemsTitles.click();
        patientPage.DdmPatientButon.click();
        patientPage.viewButton.click();
        for (WebElement w:patientPage.viewPtientList){
            w.isDisplayed();
        }
        Driver.closeDriver();

    }
}
