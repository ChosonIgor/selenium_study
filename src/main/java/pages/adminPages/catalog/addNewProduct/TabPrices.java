package pages.adminPages.catalog.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class TabPrices extends BasePage {

    private final By locatorMenuPrices = By.xpath("//li[./a[text()='Prices']]");

    public TabPrices(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.attributeToBe(locatorMenuPrices, "class", "active"));
    }
}
