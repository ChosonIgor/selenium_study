package pages.adminPages.catalog.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class TabPrices extends BasePage {

    private final By locatorMenuPrices = By.xpath("//li[./a[text()='Prices']]");
    private final By locatorFieldPurchasePrice = By.xpath("//td[./strong[text()='Purchase Price']]//input");
    private final By locatorFieldPriceUSD = By.xpath("//span[./strong[text()='USD']]/input");

    public TabPrices(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.attributeToBe(locatorMenuPrices, "class", "active"));
    }

    public TabPrices setFieldPurchasePrice(String price) {
        WebElement fieldPurchasePrice = driver.findElement(locatorFieldPurchasePrice);
        setText(fieldPurchasePrice, price);
        return this;
    }

    public TabPrices setFieldPriceUSD(String price) {
        WebElement fieldPrice = driver.findElement(locatorFieldPriceUSD);
        setText(fieldPrice, price);
        return this;
    }


}
