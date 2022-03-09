package pages.adminPages.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class EditProductPage extends BasePage {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Edit Product:')]");

    public EditProductPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }
}
