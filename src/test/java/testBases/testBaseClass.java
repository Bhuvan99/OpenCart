package testBases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class testBaseClass {
    public static WebDriver driver;
    public Properties property;
    public Logger logger;

    @BeforeClass(groups = {"Sanity","DataDriven","Master"})
    @Parameters({"os","browser"})
    public void setUp(String os,String br) throws IOException {
        FileReader file = new FileReader("C:\\Users\\bhuvanj\\Desktop\\Java_In_28_Minutes\\OpenCart\\src\\test\\resources\\config.properties");
        property = new Properties();
        property.load(file);

        logger=LogManager.getLogger(this.getClass());

        if(property.getProperty("execution_env").equalsIgnoreCase("remote")){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            if(os.equalsIgnoreCase("Windows")){
                desiredCapabilities.setPlatform(Platform.WIN10);
            }
            else if (os.equalsIgnoreCase("Mac")) {
                desiredCapabilities.setPlatform(Platform.MAC);
            }
            else{
                System.out.println("Invalid OS");
                return;
            }
            switch (br.toLowerCase()){
                case "chrome": desiredCapabilities.setBrowserName("chrome"); break;
                case "edge": desiredCapabilities.setBrowserName("MicrosoftEdge"); break;
                default: System.out.println("Invalid Browser System"); return;
            }
            driver = new RemoteWebDriver(new URL("http://192.168.1.15:4444/wd/hub"),desiredCapabilities);
        }

        if(property.getProperty("execution_env").equalsIgnoreCase("local")){
            switch (br.toLowerCase()){
                case "chrome": driver = new ChromeDriver(); break;
                case "edge": driver = new EdgeDriver();break;
                default:
                    System.out.println("Invalid Browser"); return;
            }
        }

//        driver = new EdgeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        logger = LogManager.getLogger(this.getClass());
    }
    @AfterClass(groups = {"Sanity","DataDriven","Master"})
    public void closeDriver(){
        driver.quit();
    }

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        return generatedString;
    }
    public String randomAlphaNumeric(){
        String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(10);
        return generatedAlphaNumeric;
    }

    public String randomNumeric(){
        String generatedNumeric = RandomStringUtils.randomNumeric(10);
        return generatedNumeric;
    }

    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
