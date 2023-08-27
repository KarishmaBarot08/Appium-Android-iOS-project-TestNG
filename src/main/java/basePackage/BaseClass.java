package basePackage;

import io.appium.java_client.AppiumDriver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;


public class BaseClass {

    public static AppiumDriver driver;
    public static WebDriverWait waitDriver;
    //public static AppiumDriverLocalService service;
    //public static AppiumDriverLocalService service;
    //public AppiumDriverLocalService appiumService;

    public AppiumDriverLocalService service;
    public AppiumServiceBuilder builder;


    @Parameters({"platform"})
    @BeforeClass
    public void setUp(String platformName) throws IOException, InterruptedException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


    if(platformName.equalsIgnoreCase("Android")){
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("deviceName", "moto g31");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.mproov.d");
        desiredCapabilities.setCapability("appActivity", "com.mproov.MainActivity");
        desiredCapabilities.setCapability("fullReset",true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);


        desiredCapabilities.setCapability("app", "/Users/karishmabarot/Downloads/app-dev-release.apk");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver(url, desiredCapabilities);

    }
    else if (platformName.equalsIgnoreCase("iOS")) {
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("platformVersion", "16.1.1");
        desiredCapabilities.setCapability("udid", "00008030-000258281E3B802E");
        desiredCapabilities.setCapability("automationName", "XCUI_TEST");
        //desiredCapabilities.setCapability("appPackage", "com.mproov.d");
        //desiredCapabilities.setCapability("appActivity", "com.mproov.MainActivity");
        desiredCapabilities.setCapability("xcodeOrgId","VTZ77MA855");
        desiredCapabilities.setCapability("xcodeSigningId","iPhone Developer");
        desiredCapabilities.setCapability("bundleId", "com.mproov.app.d");
        desiredCapabilities.setCapability("deviceName", "Karishma's iPhone");
        desiredCapabilities.setCapability("app", "/Users/karishmabarot/Downloads/mproov.ipa");
        //desiredCapabilities.setCapability("fullReset",true);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);




        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

    }


    }


    public static boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try
        {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }
        catch (IOException e)
        {
            isServerRunning = true;
        }
        finally
        {
            serverSocket = null;
        }
        return isServerRunning;
    }


    public static void clickByWait(WebElement webElement){
        waitDriver = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitDriver.until(ExpectedConditions.visibilityOf(webElement)).click();
    }
    public static void enterTextByWait(WebElement webElement, String text){
        waitDriver = new WebDriverWait(driver,Duration.ofSeconds(30));
        waitDriver.until(ExpectedConditions.visibilityOf(webElement)).sendKeys(text);
    }

  /* @AfterClass
    public void tearDown(){
        driver.quit();

    }*/
}
