package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{
    WebDriver driver;
//Constructors
public homePage(WebDriver driver) {
        super(driver);
    }

//    Locators
    @FindBy(xpath = "//span[normalize-space()=\"My Account\"]")
    WebElement myAccount;

    @FindBy(xpath="//a[normalize-space()=\"Register\"]")
    WebElement registerAccount;

    @FindBy(xpath = "//a[normalize-space()=\"Login\"]")
    WebElement loginAccount;


//    Action Methods
    public void clickMyAccount(){
        myAccount.click();
    }
    public void clickRegister(){
        registerAccount.click();
    }

    public void clickLogin(){
        loginAccount.click();
    }

}
