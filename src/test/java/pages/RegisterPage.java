package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#account-menu")
    public WebElement userIcon;

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerIcon;

    @FindBy(css = "#ssn")
    public WebElement SSNBox;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")//div[text()='Your SSN is required.']
    public WebElement invalidtext;

    @FindBy(xpath = "//div[text()='Your SSN is required.']")
    public WebElement SSNrequiredText;

    @FindBy(xpath = "//div[text()='Your FirstName is required.']")
    public WebElement firstnamerequiredText;

    @FindBy(xpath = "//div[text()='Your LastName is required.']")
    public WebElement lastnamerequiredText;

    @FindBy(xpath = "//div[text()='Your username is required.']")
    public WebElement usernamerequiredText;

    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement emailrequiredText;

    @FindBy(css = "#lastName")
    public WebElement lastNameBox;

    @FindBy(css = "#firstName")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[text()='baran sivan']")
    public WebElement personIconClick;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement SignoutClick;

    @FindBy(xpath = "//*[text()='Your password is required to be at least 4 characters.']")
    public WebElement passwordRequiredText;

    @FindBy(css = "#username")
    public WebElement usernameBox;

    @FindBy(css = "#email")
    public WebElement emailBox;

    @FindBy(css = "#firstPassword")
    public WebElement firstPasswordBox;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public List<WebElement> strengthBarLevelOne;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    public List<WebElement> strengthBarLeveltwo;

    @FindBy(xpath = "//li[@style='background-color: rgb(153, 255, 0);']")
    public List<WebElement> strengthBarLevelfour;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);']")
    public List<WebElement> strengthBarLevelfive;

    //LOGIN PAGE

    @FindBy(css = "#username")
    public WebElement usernameLoginBox;

    @FindBy(css = "#password")
    public WebElement passwordLoginBox;

    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[3]/button[2]//span[.='Sign in']")
    public WebElement LoginSignInButton;


}
