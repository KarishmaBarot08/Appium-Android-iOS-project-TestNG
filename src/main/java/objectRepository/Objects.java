package objectRepository;

import basePackage.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Objects extends BaseClass {

    AppiumDriver driver;

    public Objects(AppiumDriver driver) throws IOException {
        super();
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   public WebElement login_btn(){
      WebElement login_btn = driver.findElement(MobileBy.AccessibilityId("Btn_Welcome_Login"));
      return login_btn;
   }


}
