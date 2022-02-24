package pages.adminPages.catalog.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.io.File;

public class TabGeneral extends BasePage {

    private final By locatorMenuGeneral = By.xpath("//li[./a[text()='General']]");
    private final By locatorRadioEnabled = By.xpath("//label[contains(text(),'Enabled')]");
    private final By locatorRadioDisabled = By.xpath("//label[contains(text(),'Disabled')]");
    private final By locatorFieldName = By.xpath("//td[./strong[text()='Name']]//input");
    private final By locatorFieldCode = By.xpath("//td[./strong[text()='Code']]//input");
    private final By locatorCheckboxUnisex = By.xpath("//tr[./td[text()='Unisex']]//input");
    private final By locatorFieldQuantity = By.xpath("//td[./strong[text()='Quantity']]//input");
    private final By locatorFieldQuantityUnit = By.xpath("//td[./strong[text()='Quantity Unit']]//select");
    private final By locatorFieldDeliveryStatus = By.xpath("//td[./strong[text()='Delivery Status']]//select");
    private final By locatorFieldSoldOutStatus = By.xpath("//td[./strong[text()='Sold Out Status']]//select");
    private final By locatorFieldUploadImages = By.cssSelector("input[type=file]");
    private final By locatorFieldDateValidFrom = By.xpath("//td[./strong[text()='Date Valid From']]//input");
    private final By locatorFieldDateValidTo = By.xpath("//td[./strong[text()='Date Valid To']]//input");

    public TabGeneral(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.attributeToBe(locatorMenuGeneral, "class", "active"));
    }

    public TabGeneral clickToStatusEnabled() {
        clickElement(driver.findElement(locatorRadioEnabled));
        return this;
    }

    public TabGeneral setFieldName(String name) {
        WebElement fieldName = driver.findElement(locatorFieldName);
        setText(fieldName, name);
        return this;
    }

    public TabGeneral setFieldCode(String code) {
        WebElement fieldCode = driver.findElement(locatorFieldCode);
        setText(fieldCode, code);
        return this;
    }

    public TabGeneral enabledUnisexInProductGroups() {
        WebElement checkbox = driver.findElement(locatorCheckboxUnisex);
        if (checkbox.getAttribute("checked") == null) clickElement(checkbox);
        return this;
    }

    public TabGeneral setFieldQuantity(int quantity) {
        WebElement fieldQuantity = driver.findElement(locatorFieldQuantity);
        setText(fieldQuantity, String.valueOf(quantity));
        return this;
    }

    public TabGeneral choiceDeliveryStatus(int index) {
        WebElement fieldDeliveryStatus = driver.findElement(locatorFieldDeliveryStatus);
        Select objSelect = new Select(fieldDeliveryStatus);
        objSelect.selectByIndex(index);
        return this;
    }

    public TabGeneral addPhoto() {
        WebElement fieldAddPhoto = driver.findElement(locatorFieldUploadImages);
        File file = new File("src/main/resources/tiger.jpg");
        String filePath = file.getAbsolutePath();
        fieldAddPhoto.sendKeys(filePath);
        return this;
    }

    public TabGeneral setDateValidFrom(String date) {
        WebElement fieldDate = driver.findElement(locatorFieldDateValidFrom);
        fieldDate.sendKeys(date);
        return this;
    }

    public TabGeneral setDateValidTo(String date) {
        WebElement fieldDate = driver.findElement(locatorFieldDateValidTo);
        fieldDate.sendKeys(date);
        return this;
    }
}
