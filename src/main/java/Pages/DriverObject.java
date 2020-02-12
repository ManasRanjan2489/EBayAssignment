package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class DriverObject {
    public AppiumDriver<WebElement> driver;

    private HomePage homePage;
    private ProductDetailsPage productDetailsPage;
    private ProductSearchResultPage productSearchResultPage;
    private LogInPage logInPage;
    private CartPage cartPage;
    private DeliveryAddressPage deliveryAddressPage;
    private DeliveryOptionsPage deliveryOptionsPage;
    private OrderDetailsPage orderDetailsPage;
    private PaymentPage paymentPage;


    public DriverObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public LogInPage loginPage() {
        if (logInPage == null) {
            logInPage = new LogInPage(driver);
        }
        return logInPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public ProductDetailsPage productDetailsPage() {
        if (productDetailsPage == null) {
            productDetailsPage = new ProductDetailsPage(driver);
        }
        return productDetailsPage;
    }

    public ProductSearchResultPage productSearchResultPage() {
        if (productSearchResultPage == null) {
            productSearchResultPage = new ProductSearchResultPage(driver);
        }
        return productSearchResultPage;
    }

    public CartPage cartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public DeliveryAddressPage deliveryAddressPage() {
        if (deliveryAddressPage == null) {
            deliveryAddressPage = new DeliveryAddressPage(driver);
        }
        return deliveryAddressPage;
    }

    public DeliveryOptionsPage deliveryOptionsPage() {
        if (deliveryOptionsPage == null) {
            deliveryOptionsPage = new DeliveryOptionsPage(driver);
        }
        return deliveryOptionsPage;
    }

    public OrderDetailsPage orderDetailsPage() {
        if (cartPage == null) {
            orderDetailsPage = new OrderDetailsPage(driver);
        }
        return orderDetailsPage;
    }

    public PaymentPage paymentPage() {
        if (paymentPage == null) {
            paymentPage = new PaymentPage(driver);
        }
        return paymentPage;
    }
}
