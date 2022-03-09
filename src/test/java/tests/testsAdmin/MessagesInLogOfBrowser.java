package tests.testsAdmin;

import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import pages.adminPages.AuthorizationPage;
import pages.adminPages.catalog.CatalogPage;
import pages.adminPages.catalog.EditProductPage;
import tests.BaseTest;

import java.util.List;

public class MessagesInLogOfBrowser extends BaseTest {

    @Test
    public void messagesInLogTests() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        authorizationPage.authorization(username, password);
        CatalogPage catalogPage = new CatalogPage(driver,"http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<String> listProducts = catalogPage.getListProduct("Name");
        for (String product : listProducts) {
            EditProductPage editProductPage = catalogPage.gotoEditProductPage(product);
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println("На странице продукта " + product + " сообщение лога - " + l);
            }
            driver.navigate().back();
        }
    }
}
