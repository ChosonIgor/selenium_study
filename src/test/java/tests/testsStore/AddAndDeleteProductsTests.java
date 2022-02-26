package tests.testsStore;

import org.testng.annotations.Test;
import pages.storePages.CheckoutPage;
import pages.storePages.MainPage;
import pages.storePages.ProductPage;
import tests.BaseTest;

public class AddAndDeleteProductsTests extends BaseTest {

    @Test
    public void checkAddAndDeleteProducts() {
        String url = System.getProperty("mainPageURL");
        MainPage mainPage = new MainPage(driver, url);
        ProductPage productPage;
        for (int i = 0; i < 3; i++) {
            productPage = mainPage.clickFirstProduct();
            mainPage = productPage.clickButtonAddToCart().clickToLogotype();
        }
        CheckoutPage checkoutPage = mainPage.gotoCheckoutPage();
        checkoutPage.removeAllProducts();
    }


}
