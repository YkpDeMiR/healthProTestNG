package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserPage {
    public UserPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // physician administration

    @FindBy(xpath = "//span[.='My Appointments']")
    public WebElement myAppointmentsButton;

    @FindBy(linkText = "MY PAGES")
    public WebElement mYPAGESButton;

    @FindBy(css = "#appointment-heading")
    public WebElement appointment_headingText;

    @FindBy(xpath = "//div[@class='jh-card card']")
    public WebElement jh_card_cardTextTable;


}
