package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage{

//    Constructor
    public loginPage(WebDriver driver){
        super(driver);
    }
//    Locators
    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement usertxtEmail;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement usertxtPassword;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement txtSubmit;

//    Action Methods

    public void setUserEmail(String userEmail){
        usertxtEmail.sendKeys(userEmail);
    }
    public void setUserPassword(String userPassword){
        usertxtPassword.sendKeys(userPassword);
    }

    public void clickSubmit(){
        txtSubmit.click();
    }
}
