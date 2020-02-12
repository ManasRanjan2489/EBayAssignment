package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends GlobalPage {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    public ProductDetailsPage(AppiumDriver<WebElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    @AndroidFindBy(id = "")
    private WebElement Name;

    @AndroidFindBy(id = "")
    private WebElement Price;

    @AndroidFindBy(id = "")
    private WebElement Description;

    public void verifyUserInProductDetailPage() {
    }



    


}
