package Pages;

import Utils.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class HomePage extends GlobalPage {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    public HomePage(AppiumDriver<WebElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 30);
    }

    @AndroidFindBy(id = "rs_search_src_text")
    private WebElement SearchBar;

    @AndroidFindBy(id = "rs_vertical_stack_view")
    private WebElement SearchResults;

    @AndroidFindBy(id = "nick_name")
    private WebElement NickNameTextField;

    @AndroidFindBy(id = "firstNameText")
    private WebElement firstNameTextField;

    public void verifyUserInHomePage() {

    }

    public void searchProduct(String ProductName) {
        clickOn(SearchBar);
        typeInHitEnter(SearchBar, ProductName);
    }

    public void selectARandomProductFromList(int num) {
        scroll();
        List<WebElement> productResults = driver.findElementsById("rs_vertical_stack_view");
        if (!productResults.isEmpty()) {
            productResults.get(num).click();
        }
    }

}
