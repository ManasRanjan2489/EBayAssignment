package CheckoutProduct;

import Base.Base;
import Pages.DriverObject;
import Utils.Constants;
import org.testng.annotations.Test;

public class CheckoutAProductAfterSearch extends Base {
    public DriverObject driverObject;

    @Test
    public void checkout() {
        driverObject = new DriverObject(driver);
        driverObject.homePage().searchProduct(Constants.SEARCH_PRODUCT);
        driverObject.homePage().selectARandomProductFromList(3);


    }
}
