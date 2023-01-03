package tests.UI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import utilities.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Appointment_UI {

    AppointmentPage appointmentPage = new AppointmentPage();

    @DataProvider
    public Object[][] appointmentRegister() {
        Object[][] chars = {
                {"ara", "guler", "543-63-5214", "maxplanck@testmail.com", "123-85-6951"},
                {"@", "$", "244-45-5214", "jhkl@testmail.com", "345-78-6951"},
                {"..", "?", "244-63-5423", "dfgh@testmail.com", "872-85-4587"},
        };
        return chars;
    }

    @Test(dataProvider = "appointmentRegister")
    public void testfirstName(String chars, String sn, String ssn, String email, String phone) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaAppointmentUrl"));
        JSUtils.scrollIntoViewJS(appointmentPage.firstNameBox);
        ReusableMethods.waitAndSendText(appointmentPage.firstNameBox, chars);
        ReusableMethods.waitAndSendText(appointmentPage.lastNameBox, sn);
        ReusableMethods.waitAndSendText(appointmentPage.ssnBox, ssn);
        ReusableMethods.waitAndSendText(appointmentPage.emailBox, email);
        ReusableMethods.waitAndSendText(appointmentPage.phoneBox, phone);
        //appointmentPage.ssnBox.click();


    }

    @Test(dependsOnMethods = "testfirstName")
    public void tearDown() {
        Driver.closeDriver();
    }

    @DataProvider
    public Object[][] appointmentRegisterBlank() {
        Object[][] chars = {

                {"", "", "", "", ""}

        };
        return chars;
    }

    @Test(dataProvider = "appointmentRegisterBlank")
    public void testBlank(String chars, String sn, String ssn, String email, String phone) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaAppointmentUrl"));
        JSUtils.scrollIntoViewJS(appointmentPage.firstNameBox);
        ReusableMethods.waitAndSendText(appointmentPage.firstNameBox, chars);
        ReusableMethods.waitAndSendText(appointmentPage.lastNameBox, sn);
        ReusableMethods.waitAndSendText(appointmentPage.ssnBox, ssn);
        ReusableMethods.waitAndSendText(appointmentPage.phoneBox, phone);
        ReusableMethods.waitAndSendText(appointmentPage.emailBox, email);
        ReusableMethods.waitAndSendText(appointmentPage.appoDateBox, email);
        appointmentPage.firstnamerequiredText.isDisplayed();
        appointmentPage.LastNamerequiredText.isDisplayed();
        appointmentPage.SSNrequiredText.isDisplayed();
        appointmentPage.PhonerequiredText.isDisplayed();
        appointmentPage.emailrequiredText.isDisplayed();


    }

    @Test(dependsOnMethods = "testBlank")
    public void tearDownBlank() {
        Driver.closeDriver();
    }

    String today = new SimpleDateFormat("MM/dd/yyyy").format(new Date());

    @DataProvider
    public Object[][] appointmentRegisterFull() {
        Object[][] chars = {

                {"ara", "guler", "543-63-5214", "maxplanck1@testmail.com", "123-854-6951"}
        };
        return chars;
    }

    @Test(dataProvider = "appointmentRegisterFull")
    public void testFull(String chars, String sn, String ssn, String email, String phone) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaAppointmentUrl"));
        JSUtils.scrollIntoViewJS(appointmentPage.firstNameBox);
        ReusableMethods.waitAndSendText(appointmentPage.firstNameBox, chars);
        ReusableMethods.waitAndSendText(appointmentPage.lastNameBox, sn);
        ReusableMethods.waitAndSendText(appointmentPage.ssnBox, ssn);
        ReusableMethods.waitAndSendText(appointmentPage.emailBox, email);
        ReusableMethods.waitAndSendText(appointmentPage.phoneBox, phone);
        LocalDate date = LocalDate.now();
        //System.out.println(date.minusDays(1));
        String yarin = String.valueOf(date.plusDays(1));
        //String today = new SimpleDateFormat("12-28-2023").format(new Date());
        ReusableMethods.waitAndSendText(appointmentPage.appoDateBox, testName());
        JSUtils.clickElementByJS(appointmentPage.registersubmitButton);

        //appointmentPage.ssnBox.click();

    }

    @Test(dependsOnMethods = "testFull")
    public void tearDownFull() {
        Driver.closeDriver();
    }



    public String testName() {

        LocalDate date = LocalDate.now();
        //System.out.println(date.minusDays(1));
        String yarin = String.valueOf(date.plusDays(1));
        System.out.println(yarin);
        int gun = (date.getDayOfMonth() + 1);
        int yil = date.getYear();
        int ay = date.getMonthValue();

        if (ay==2&&gun>28){
            gun=1;
            ay=ay+1;
        }

        if (gun>30){
            gun=1;
            ay=ay+1;
        }

        if (ay>12){
            ay=1;
            yil=yil+1;
        }

        String day = String.valueOf(gun);
        String month = String.valueOf(ay);
        String year = String.valueOf(yil);

        if (day.length()<2){
            day="0"+day;
        }

        if (month.length()<2){
            month="0"+month;
        }


        yarin = month +"/"+ day +"/" + year;
        System.out.println("yarin = " + yarin);
        return yarin;
    }
}
