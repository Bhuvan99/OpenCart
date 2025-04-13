package testCases;

import PageObjects.MyAccountPage;
import PageObjects.homePage;
import PageObjects.loginPage;
import UtilityFiles.DataProviders;
import org.apache.logging.log4j.LogManager;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBases.testBaseClass;

import org.apache.logging.log4j.Logger;

public class TC002_LoginTestDDT extends testBaseClass {
    private static final Logger logger = LogManager.getLogger(TC001_AccountRegistration.class);
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"DataDriven","Master"})
    public void verifyLoginDDT(String email, String pwd, String expRes){


        logger.info("******** Started the Login DDT Execution **********");
        try {
//       Home Page Actions
            homePage hp = new homePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

//      Login Page Actions
            loginPage lp = new loginPage(driver);
            lp.setUserEmail(email);
            lp.setUserPassword(pwd);
            lp.clickSubmit();

//      My Account Page existence
            MyAccountPage myAccPage = new MyAccountPage(driver);
            boolean targetPage = myAccPage.myAccountPage();

            if (expRes.equalsIgnoreCase("pass")) {
                if (targetPage == true) {
                    myAccPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (expRes.equalsIgnoreCase("fail")) {
                if (targetPage == true) {
                    myAccPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){
            Assert.fail();
        }
        logger.info("********* Completed the Login DDT Execution Successfully ************");
    }
}
