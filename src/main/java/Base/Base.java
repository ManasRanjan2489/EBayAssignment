package Base;

import Utils.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    ConfigReader config;
    public DesiredCapabilities capabilities;

    @BeforeMethod
    public void setUp(String deviceName, String platformVersion, String platformName, String udid, String url) throws MalformedURLException {
        config = new ConfigReader();
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", config.getDeviceName());
        capabilities.setCapability("platformVersion", config.getPlatformVersion());
        capabilities.setCapability("platformName", config.getPlatformName());
        capabilities.setCapability("appPackage", config.getAppPackage());
        capabilities.setCapability("appActivity", config.getAppActivity());
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        try {
            driver = new AppiumDriver<MobileElement>(new URL(url), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (SessionNotCreatedException e) {
            Reporter.log("Unable to create Appium session");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("The exception is" + e.getLocalizedMessage());
        }
    }


    @AfterMethod
    public void close() {
        driver.closeApp();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
