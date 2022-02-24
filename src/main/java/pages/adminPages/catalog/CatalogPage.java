package pages.adminPages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.BaseTable;
import pages.adminPages.catalog.addNewProduct.AddNewProductPage;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage extends BaseTable {

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

    public List<String> getListColumnsValue(String nameColumn) {
        int index = getNameColumn().indexOf(nameColumn) + 1;
        List<WebElement> valueColumnList = driver.findElements(By.xpath("//tbody[./tr[@class='header']]/tr/td[" + index + "]"));
        List<String> columnsValue = new ArrayList<>();
        for (WebElement cell : valueColumnList) {
            columnsValue.add(cell.getText());
        }
        return columnsValue;
    }
}
