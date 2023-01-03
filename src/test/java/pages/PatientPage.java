package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PatientPage {

    public PatientPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Items&Titles")
    public WebElement ItemsTitles;

    @FindBy(xpath = "//*[@id='entity-menu']//div//span[.='Patient']")
    public WebElement DdmPatientButon;

    @FindBy(xpath = "//div//dt/span")
    public List<WebElement> viewPtientList;

    @FindBy(xpath = "//tbody//tr//div/a")
    public WebElement viewButton;



}
