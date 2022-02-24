package pages.adminPages.catalog.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class AddNewProductPage extends BasePage {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Add New Product')]");
    private final By locatorMenuGeneral = By.xpath("//li[./a[text()='General']]");
    private final By locatorMenuInformation = By.xpath("//li[./a[text()='Information']]");
    private final By locatorMenuPrices = By.xpath("//li[./a[text()='Prices']]");

    TabGeneral tabGeneral;
    TabInformation tabInformation;
    TabPrices tabPrices;

    public AddNewProductPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public TabGeneral tabGeneral() {
        if (tabGeneral == null) tabGeneral = new TabGeneral(driver);
        return tabGeneral;
    }

    public TabInformation tabInformation() {
        if (tabInformation == null) tabInformation = new TabInformation(driver);
        return tabInformation;
    }

    public TabPrices tabPrices() {
        if (tabPrices == null) tabPrices = new TabPrices(driver);
        return tabPrices;
    }

    public void gotoTabGeneral() {
        WebElement buttonGeneral = driver.findElement(locatorMenuGeneral);
        if (!buttonGeneral.getAttribute("class").equals("active")) clickElement(buttonGeneral);
    }

    public void gotoTabInformation() {
        WebElement buttonInformation = driver.findElement(locatorMenuInformation);
        if (!buttonInformation.getAttribute("class").equals("active")) clickElement(buttonInformation);
    }

    public void gotoTabPrices() {
        WebElement buttonPrices = driver.findElement(locatorMenuPrices);
        if (!buttonPrices.getAttribute("class").equals("active")) clickElement(buttonPrices);
    }







}
