package tests.testsStore;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.storePages.MainPage;
import tests.BaseTest;

import java.util.List;

public class MainPageTests extends BaseTest {

    @Test
    public void checkExistsStickers() {
        String url = System.getProperty("mainPageURL");
        MainPage mainPage = new MainPage(driver, url);
        List<WebElement> listProduct = mainPage.getListProduct();
        for (WebElement product:listProduct) {
            mainPage.checkExistAStickerInProduct(product);
        }
    }
}
