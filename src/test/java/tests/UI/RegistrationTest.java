package tests.UI;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class RegistrationTest {
    RegisterPage registerPageUS12 = new RegisterPage();

    @DataProvider
    public Object[][] invalidSsnLength() {

        Object[][] employeeCredentials = {
                {"123-23-12345"},
                {"123-23-123"},
                {"623-23-823"},
                {"123-23-123464"},
                {"123-23-123679"}

        };
        return employeeCredentials;
    }

    @DataProvider
    public Object[][] invalidSsnChar() {

        Object invalidChar[][] = {
                {"a23-23-1234"},
                {"@23-23-1234"},
                {"=23-23-8234"},
                {"1*3-23-1234"}};
        return invalidChar;
    }


    public void registerMethod() {

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
        registerPageUS12.userIcon.click();
        registerPageUS12.registerIcon.click();

    }


    @Test
    public void sSNForm() {


        //1- Kullanici anasayfaya gider
        //2- Kullanici dashboarddaki kullanici butonuna tiklar
        //3- Kullanici Register butonuna tiklar
        //4- Kullanici SSN butonuna tiklar
        //5- Kullanici gecerli SSN girer
        //6- "Your SSN is invalid " yazisinin gorulmedigi dogrulanir
        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.SSNBox, ConfigReader.getProperty("SSNvalid"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        assert wait.until(ExpectedConditions.invisibilityOf(registerPageUS12.invalidtext));
        //Driver.closeDriver();

    }

    @Test
    public void ssnBlankTest() {
        //1- Kullanici anasayfaya gider
        //2- Kullanici dashboarddaki kullanici butonuna tiklar
        //3- Kullanici Register butonuna tiklar
        //4- Kullanici SSN kutusuna tiklar
        //5- Kullanici SSN kutusunu bos birakip First Name kutusuna tiklar
        //6- "Your SSN is required " yazisinin goruldugu dogrulanir

        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.SSNBox, "");
        registerPageUS12.firstNameBox.click();
        assert registerPageUS12.SSNrequiredText.isDisplayed();
        Driver.closeDriver();
    }

    @Test
    public void testInvalidSsnForm() {
        //1- Kullanici anasayfaya gider
        //2- Kullanici dashboarddaki kullanici butonuna tiklar
        //3- Kullanici Register butonuna tiklar
        //4- Kullanici SSN butonuna tiklar
        //5- Kullanici gecersiz bir SSN girer
        //6- "Your SSN is invalid " yazisinin goruldugu dogrulanir
        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.SSNBox, "SSNInvalid");
        registerPageUS12.firstNameBox.click();
        assert registerPageUS12.invalidtext.isDisplayed();
        Driver.closeDriver();
    }

    @Test(dataProvider = "invalidSsnLength")
    public void testInvalidSsnLength(String invalidSsn) {
        //1- Kullanici anasayfaya gider
        //2- Kullanici dashboarddaki kullanici butonuna tiklar
        //3- Kullanici Register butonuna tiklar
        //4- Kullanici SSN butonuna tiklar
        //5- Kullanici gecersiz SSN girer
        //6- "Your SSN is invalid " yazisinin gorulmedigi dogrulanir
        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.SSNBox, invalidSsn);
        registerPageUS12.firstNameBox.click();
        assert registerPageUS12.invalidtext.isDisplayed();

    }

    @Test(dependsOnMethods = "testInvalidSsnLength")
    public void test3() {
        Driver.closeDriver();
    }

    @Test(dataProvider = "invalidSsnChar")
    public void testInvalidSsnChar(String invalidSsn) {
        //1- Kullanici anasayfaya gider
        //2- Kullanici dashboarddaki kullanici butonuna tiklar
        //3- Kullanici Register butonuna tiklar
        //4- Kullanici SSN butonuna tiklar
        //5- Kullanici gecersiz SSN girer
        //6- "Your SSN is invalid " yazisinin gorulmedigi dogrulanir
        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.SSNBox, invalidSsn);
        registerPageUS12.firstNameBox.click();
        assert registerPageUS12.invalidtext.isDisplayed();

    }

    @Test(dependsOnMethods = "testInvalidSsnChar")
    public void test4() {
        Driver.closeDriver();
    }

    @Test
    public void testName() {

        //1- Kullanici anasayfaya gider
        //2- Kullanici dashboarddaki kullanici butonuna tiklar
        //3- Kullanici Register butonuna tiklar
        //4- Kullanici First Name kutusuna tiklar ve bos birakir
        //5- Kullanici Last Name kutusuna tiklar ve bos birakir
        //"6- ""Your FirstName is required""  ve ""Your LastName is required ""
        //yazisinin goruldugu dogrulanir"
        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.firstNameBox, "");
        ReusableMethods.waitAndSendText(registerPageUS12.lastNameBox, "");
        registerPageUS12.SSNBox.click();
        assert registerPageUS12.lastnamerequiredText.isDisplayed();
        assert registerPageUS12.firstnamerequiredText.isDisplayed();
        Driver.closeDriver();
    }

    //US002 


    @Test
    public void testUsernameChar() {
        //1- Kullanici Url ile giris yapar
        //2-Kullanici Register sayfasina gider
        //3-Kullanici Username alanina herhangi bir karakter girer
        //4-"Your username is required" uyarisi almadigini dogrular.
        Faker faker =new Faker();
        registerMethod();
      ReusableMethods.waitAndSendText(registerPageUS12.firstNameBox, faker.name().prefix());
        registerPageUS12.SSNBox.click();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),2);
      assert   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Your LastName is required.']")));
        Driver.closeDriver();
    }

    @Test
    public void testUsernameBlank() {
        //1- Kullanici Url ile giris yapar
        //2-Kullanici Register sayfasina gider
        //3-Kullanici Username alanini bos birakir
        //4-"Your username is required" uyarisi aldigini dogrular.
        registerMethod();
        ReusableMethods.waitAndSendText(registerPageUS12.usernameBox, "");
        registerPageUS12.SSNBox.click();
        assert registerPageUS12.usernamerequiredText.isDisplayed();
        Driver.closeDriver();
    }

    @Test
    public void testUsernameAnyChar() {
        //1- Kullanici Url ile giris yapar
        //2-Kullanici Register sayfasina gider.
        //3-Kullanici Username alanina herhangi bir karakter girer
        //4-"Your username is required" uyarisi almadigini dogrular.
        registerMethod();
        Faker faker =new Faker();
        ReusableMethods.waitAndSendText(registerPageUS12.usernameBox, faker.internet().password().substring(0,1));
        registerPageUS12.firstNameBox.click();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),2);
        assert   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Your username is required.']")));
        Driver.closeDriver();
    }

    @Test
    public void testEmail() {
        //1- Kullanici Url ile giris yapar
        //2-Register sayfasina gider.
        //3-Kullanici Email alanina @ ve . Karakterleri iceren bir mail adresi girdiginde uyari almamali
        //4-This field is invalid uyarisi almadigini dogrular.
        registerMethod();
        Faker faker =new Faker();
        ReusableMethods.waitAndSendText(registerPageUS12.emailBox,faker.name().username() + "@"+faker.name().firstName()+".com"+faker.name().lastName());
        registerPageUS12.SSNBox.click();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),2);
        assert   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='Your email is required.']")));
        Driver.closeDriver();
    }


}
