package pages.adminPages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.adminPages.catalog.addNewProduct.AddNewProductPage;

public class CatalogPage extends BasePage {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Catalog')]");
    private final By locatorButtonAddNewProduct = By.xpath("//a[contains(text(), 'Add New Product')]");
    public CatalogPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public AddNewProductPage gotoAddNewProductPage() {
        clickElement(driver.findElement(locatorButtonAddNewProduct));
        return new AddNewProductPage(driver);
    }


}
