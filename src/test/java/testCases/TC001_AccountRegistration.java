package testCases;

import PageObjects.homePage;
import PageObjects.registerPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBases.testBaseClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TC001_AccountRegistration extends testBaseClass {
    private static Logger logger = LogManager.getLogger(TC001_AccountRegistration.class);

    @Test(groups = {"Sanity","Master"})
    public void account_registration(){
        logger.info("*****Started TC001_AccountRegistration Case*****");
            String pwd = randomAlphaNumeric();
//        homepage
        logger.info("Opening the HomePage to Register");
            homePage hp = new homePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();

//        Registration Page
        logger.info("Updating the mandatory details for account registration");
            registerPage regPage = new registerPage(driver);
            logger.info("Entering the Name");
            regPage.setTxtFirstName(randomString());
            regPage.setTxtLastName(randomString());
            logger.info("Entering the mail credential");
            regPage.setTxtEmail(randomAlphaNumeric()+"@gmail.com");
            logger.info("Entering the Number");
            regPage.setTxtNumber(randomNumeric());
            logger.info("Entering the password");
            regPage.setTxtPassword(pwd);
            regPage.setTxtCnfPassword(pwd);
            logger.info("Clicking the Agree Box");
            regPage.setTxtAgreeBox();
            logger.info("Clicking the submit button");
            regPage.setTxtSubmit();
            logger.info("Validating the Confirmation Message");
            String cnfMessageval = regPage.getConfirmMessage();
            if(cnfMessageval.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
                logger.info("**TC001_AccountRegistration passed**");
            }
            else{
                Assert.assertTrue(false);
                logger.info("**TC001_AccountRegistration failed**");
            }
        logger.info("*****TC001_AccountRegistration Execution Completed**");
    }
}
