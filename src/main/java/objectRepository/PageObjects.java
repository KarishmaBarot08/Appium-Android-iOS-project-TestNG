package objectRepository;

import basePackage.BaseClass;
import functions.Functions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class PageObjects extends BaseClass {

    AppiumDriver driver;
    public FileReader reader;
    public Properties prop;


    public PageObjects(AppiumDriver driver) throws IOException {


        this.driver = driver;
       /* try {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        PageFactory.initElements(driver,this);
        reader = new FileReader(System.getProperty("user.dir")+"/src/main/java/utility/config.properties");
        prop = new Properties();
        prop.load(reader);

    }


    //@AndroidFindBy(id = "Btn_Welcome_Login")
    //@iOSXCUITFindBy(accessibility = "Btn_Welcome_Login")
    @FindBy(id = "Btn_Welcome_Login")
    public WebElement login_btn;

    @FindBy(id = "Login_PhoneNumber_Input")
    public WebElement phone_number;

    @FindBy(id = "textfield_signin_password")
    public WebElement password;

    @FindBy(id = "btn_countrypicker")
    public WebElement countryPicker;

    @FindBy(id = "text-input-country-filter")
    public WebElement countryCode;

    @FindBy(id = "country-selector-IN")
    public WebElement selectCountryIN;

    @FindBy(id = "country-selector-US")
    public WebElement selectCountryUS;
    @FindBy(id = "Btn_Login")
    public WebElement login;


    public WebElement getLogin_btn() {
        return login_btn;
    }

    public WebElement getPhone_number() {
        return phone_number;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getCountryPicker() {
        return countryPicker;
    }

    public WebElement getCountryCode() {
        return countryCode;
    }

    public WebElement getSelectCountryIN() {
        return selectCountryIN;
    }
    public WebElement getSelectCountryUS() {
        return selectCountryUS;
    }
}
