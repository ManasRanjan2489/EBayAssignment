package Pages;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GlobalPage {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;

    public GlobalPage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }


    public void clearInputField(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            locator.clear();
        } catch (Exception e) {
            throw new RuntimeException("element is not displayed");
        }
    }

    public void typeIn(WebElement locator, final String element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
            locator.click();
            locator.sendKeys(element);
        } catch (Exception e) {
            throw new RuntimeException("element is not displayed");
        }

    }


    public void clickOn(WebElement locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            locator.click();
        } catch (Exception e) {
            if (!locator.isDisplayed()) {
                throw new NoSuchElementException(locator.toString(), e);
            } else {
                if (!locator.isEnabled()) {
                    throw new RuntimeException("element is not displayed");
                }
            }

        }
    }

    public void typeInHitEnter(final WebElement element, final String input) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(input + Keys.RETURN);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public void tapAnElement(WebElement locator) {
        MobileElement source = (MobileElement) driver.findElementById("");
        MobileElement target = (MobileElement) driver.findElementById("");
        TouchAction act = new TouchAction((MobileDriver) driver);
        act.longPress(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
        act.press(ElementOption.element(source)).moveTo(ElementOption.element(target)).release().perform();
    }

    public void scrollUsingTouchActions_ByElements(MobileElement startElement, MobileElement endElement) {
        TouchAction actions = new TouchAction(driver);
        actions.press(ElementOption.element(startElement)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(ElementOption.element(endElement)).release().perform();
    }

    public void scroll() {
        MobileElement listItem = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().description(\"- Add to cart\"));"));

    }


    //Method - 1
    public void voidSwipevertical(AndroidDriver<MobileElement> driver, double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.getWidth() / 2);
        int startPoint = (int) (size.getHeight() * startPercentage);

        int endPoint = (int) (size.getHeight() * endPercentage);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction().moveTo(PointOption.point(width, endPoint)).release().perform();

    }

    //Method - 2
    public void voidSwipevertical2(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage) {
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.getWidth() / 2);
        int startPoint = (int) (size.getHeight() * startPercentage);

        int endPoint = (int) (size.getHeight() * endPercentage);
        new TouchAction(driver).press(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, endPoint)).release().perform();
    }

    //Method - 3
    public void voidSwipevertical3(AndroidDriver<WebElement> driver, double startPercentage, double endPercentage) throws Exception {
        Dimension size = driver.manage().window().getSize();
        int width = (int) (size.getWidth() / 2);
        int startPoint = (int) (size.getHeight() * startPercentage);

        int endPoint = (int) (size.getHeight() * endPercentage);

        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(width, startPoint)).moveTo(PointOption.point(width, endPoint)).release().perform();
    }


    public List<WebElement> getElements(String idName) {
        return driver.findElementsById(idName);
    }

    public void clickOnMultiple(String idName, int random) {
        try {
            getElements(idName).get(random).click();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void explicitWait(WebElement locator, int timeInSec) {
        wait = new WebDriverWait(driver, timeInSec);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void impliciteWait(int timeInSec) {
        driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
    }

    public void waitFor() throws InterruptedException {
        Thread.sleep(10000);
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }


    public String getText(WebElement locator) {
        if (locator.isDisplayed()) {
            return locator.getText();
        } else
            throw new RuntimeException("element is not displayed" + locator.toString());
    }

}
