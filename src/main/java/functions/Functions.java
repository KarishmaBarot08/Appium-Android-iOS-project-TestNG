package functions;

import basePackage.BaseClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import objectRepository.Objects;
import objectRepository.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Functions extends BaseClass {
    AppiumDriver driver;
    FileReader reader;
    Properties prop;


    public Functions(AppiumDriver driver) throws IOException {
        this.driver = driver;
        reader = new FileReader(System.getProperty("user.dir")+"/src/main/java/utility/config.properties");
        prop = new Properties();
        prop.load(reader);
    }

    public void login_flow() throws IOException {
        PageObjects po = new PageObjects(driver);
        clickByWait(po.getLogin_btn());
        clickByWait(po.getCountryPicker());


        if(prop.getProperty("platformName").equalsIgnoreCase("Android")) {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollIntoView(new UiSelector()" + ".textContains(po.prop.getProperties(\"countryNameAndroid"+"\")).instance(0))")).click();
            //driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" + ".scrollIntoView(new UiSelector()" + ".textContains(\"" + "India (+91)"+ "\").instance(0))")).click();
        }
        else{
            enterTextByWait(po.getCountryCode(),prop.getProperty("countryNameIOS"));
            clickByWait(po.getSelectCountryIN());


        }
        enterTextByWait(po.getPhone_number(),"9737176067");
        enterTextByWait(po.getPassword(),"Test@123");
        clickByWait(po.getLogin());


    }


}
