package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#account-menu")
    public WebElement userIcon;

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerIcon;

    @FindBy(xpath = "//*[.='Sign out']")
    public WebElement signoutButton;

    @FindBy(xpath = "//span[.='Did you forget your password?']")
    public WebElement forgetpasswordButton;

    @FindBy(xpath = "//*[.='Reset your password']")
    public WebElement Resetyourpasswordtext;

    @FindBy(xpath = "//*[.='User management']")
    public WebElement usermanagementButton;

    @FindBy(xpath = "//*[.='Create a new user']")
    public WebElement createanewuserButton;


    @FindBy(css = "#rememberMe")
    public WebElement rememberMeButton;

    @FindBy(css = "#admin-menu")
    public WebElement admin_menuButton;

    //create a new user

    @FindBy(css = "#login")
    public WebElement loginText;

    @FindBy(css = "#lastName")
    public WebElement lastNameBox;

    @FindBy(css = "#firstName")
    public WebElement firstNameBox;

    @FindBy(css = "#email")
    public WebElement emailBox;

    @FindBy(css = "#ssn")
    public WebElement SSNBox;

    @FindBy(css = "#langKey")
    public WebElement ddmLanguage;

    @FindBy(css = "#authorities")
    public WebElement ddmRole;

    @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButton;


    //LOGIN PAGE

    @FindBy(css = "#username")
    public WebElement usernameLoginBox;

    @FindBy(css = "#password")
    public WebElement passwordLoginBox;

    @FindBy(xpath = "//*[@id=\"login-page\"]/div/form/div[3]/button[2]//span[.='Sign in']")
    public WebElement LoginSignInButton;


}
