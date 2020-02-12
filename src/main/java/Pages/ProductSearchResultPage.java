package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductSearchResultPage extends GlobalPage {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    public ProductSearchResultPage(AppiumDriver<WebElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    @AndroidFindBy(id = "action_bar_titleText")
    private WebElement addFriendTitleText;

    @AndroidFindBy(id = "myinfolay")
    private WebElement FriendInfoText;

    @AndroidFindBy(id = "nick_name")
    private WebElement NickNameTextField;

    @AndroidFindBy(id = "firstNameText")
    private WebElement firstNameTextField;
}
