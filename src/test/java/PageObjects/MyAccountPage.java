package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends basePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h2[normalize-space()=\"My Account\"]")
    WebElement txtMyAccount;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement txtLogOut;

    public boolean myAccountPage() {
        try {
            return txtMyAccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickLogout(){
        txtLogOut.click();
    }

}
