package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPage {

    public AppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='header']//span")
    public WebElement makeappointmentButton;

    @FindBy(css = "#firstName")
    public WebElement firstNameBox;

    @FindBy(css = "#ssn")
    public WebElement ssnBox;

    @FindBy(css = "#email")
    public WebElement emailBox;

    @FindBy(css = "#lastName")
    public WebElement lastNameBox;

    @FindBy(css = "#appoDate")
    public WebElement appoDateBox;


    @FindBy(css = "#phone")
    public WebElement phoneBox;

    @FindBy(css = "#register-submit")
    public WebElement registersubmitButton;


    @FindBy(xpath = "//div[text()='Your FirstName is required.']")
    public WebElement firstnamerequiredText;

     @FindBy(xpath = "//div[text()='Your SSN is required.']")
    public WebElement SSNrequiredText;

     @FindBy(xpath = "//div[text()='Your LastName is required.']")
    public WebElement LastNamerequiredText;

     @FindBy(xpath = "//div[text()='Phone number is required.']")
    public WebElement PhonerequiredText;

     @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement emailrequiredText;


}
