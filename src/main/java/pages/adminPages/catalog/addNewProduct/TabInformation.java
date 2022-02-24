package pages.adminPages.catalog.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class TabInformation extends BasePage {

    private final By locatorMenuInformation = By.xpath("//li[./a[text()='Information']]");

    public TabInformation(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.attributeToBe(locatorMenuInformation, "class", "active"));
    }
}
