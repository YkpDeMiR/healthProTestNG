package tests.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Password_test {


    RegisterPage registerPage = new RegisterPage();

    @DataProvider
    public Object[][] passwordUpperCaseTest() {

        Object[][] password = {{"123as@?", "123as@?A"},
                {"123as@?", "123as@?X"},
                {"123as@?", "123as@?V"},
                {"123as@?", "123as@?Y"}};

        return password;
    }


    @Test(dataProvider = "passwordUpperCaseTest")
    public void test1(String x, String y) {
        // There should be at least 1 UpperCase char for stronger password and
        // see the level chart change accordingly
        Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, x);
        int level1 = registerPage.strengthBarLevelfour.size();
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, y);
        int level2 = registerPage.strengthBarLevelfive.size();
        assert level2 > level1;
    }

    @Test(dependsOnMethods = "test1")
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void test2() {
        //There should be at least 1 lowercase char and see the level chart change accordingly
        Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "123DG@?");
        int level1 = registerPage.strengthBarLevelfour.size();
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "123DG@?a");
        int level2 = registerPage.strengthBarLevelfive.size();
        assert level2 > level1;
        Driver.closeDriver();
    }

    @Test
    public void test3() {
        //There should be at least 1 digit and see the level chart change accordingly
        Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvDG@?");
        int level1 = registerPage.strengthBarLevelfour.size();
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvDG@?1");
        int level2 = registerPage.strengthBarLevelfive.size();
        assert level2 > level1;
        Driver.closeDriver();
    }

    @Test
    public void test4() {
        //There should be at least 1 special char and see the level bar change accordingly
        Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvDG@1");
        int level1 = registerPage.strengthBarLevelfour.size();
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvDG@1?");
        int level2 = registerPage.strengthBarLevelfive.size();
        assert level2 > level1;
        Driver.closeDriver();
    }


    @Test
    public void test5() {
        //There should be at least 1 special char and see the level bar change accordingly
        Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvDG@1");
        int level1 = registerPage.strengthBarLevelfour.size();
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvDG@1?");
        int level2 = registerPage.strengthBarLevelfive.size();
        assert level2 > level1;
        Driver.closeDriver();
    }

    @Test
    public void test6() {
        //For a valid passcode, there should be at least 4 chars
        Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acv");
        registerPage.emailBox.click();
        registerPage.passwordRequiredText.isDisplayed();
        ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvl");
        registerPage.emailBox.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Your password is required to be at least 4 characters.']")));
        Driver.closeDriver();
    }


     @Test
    public void test7() {
        //There should be at least 7 chars for a stronger password
         Driver.getDriver().get(ConfigReader.getProperty("medunnaRegisterUrl"));
         ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvD12");
         int level1 = registerPage.strengthBarLevelOne.size();
         ReusableMethods.waitAndSendText(registerPage.firstPasswordBox, "acvD123");
         int level2 = registerPage.strengthBarLevelfour.size();
         assert level2 > level1;
         Driver.closeDriver();
    }




}
