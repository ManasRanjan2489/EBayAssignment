package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage extends GlobalPage {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    public LogInPage(AppiumDriver<WebElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    public void verifyUserIsInLoginPage() {

    }
}
