package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage extends basePage{
//    Constructors
    WebDriver driver;
    public registerPage(WebDriver driver){
        super(driver);
    }

//    Locators
    @FindBy(xpath = "//input[@name=\"firstname\"]")
    WebElement txtFirstName;
    @FindBy(xpath="//input[@name=\"lastname\"]")
    WebElement txtLastName;
    @FindBy(xpath="//input[@name=\"email\"]")
    WebElement txtEmail;
    @FindBy(xpath="//input[@name=\"telephone\"]")
    WebElement txtNumber;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement txtPassword;
    @FindBy(xpath="//input[@name=\"confirm\"]")
    WebElement txtCnfPassword;
    @FindBy(xpath = "//input[@name=\"agree\"]")
    WebElement txtAgreeBox;
    @FindBy(xpath = "//input[@type=\"submit\"]")
    WebElement txtSubmit;
    @FindBy(xpath = "//h1[normalize-space()=\"Your Account Has Been Created!\"]")
    WebElement cnfMessage;

//    Action Methods
    public void setTxtFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }
    public void setTxtLastName(String lastName){
        txtLastName.sendKeys(lastName);
    }
    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtNumber(String number){
        txtNumber.sendKeys(number);
    }
    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void setTxtCnfPassword(String cnfPassword){
        txtCnfPassword.sendKeys(cnfPassword);
    }
    public void setTxtAgreeBox(){
        txtAgreeBox.click();
    }
    public void setTxtSubmit(){
        txtSubmit.click();
    }
    public String getConfirmMessage(){
        try{
            return (cnfMessage.getText());
        }
        catch (Exception e){
            return (e.getMessage());
        }
    }
}
