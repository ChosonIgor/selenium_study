package pages.adminPages.catalog.addNewProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class TabInformation extends BasePage {

    private final By locatorMenuInformation = By.xpath("//li[./a[text()='Information']]");
    private final By locatorFieldKeywords = By.xpath("//td[./strong[text()='Keywords']]//input");
    private final By locatorFieldShortDescription = By.xpath("//td[./strong[text()='Short Description']]//input");
    private final By locatorFieldDescription = By.xpath("//td[./strong[text()='Description']]//div[@class='trumbowyg-editor']");

    public TabInformation(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.attributeToBe(locatorMenuInformation, "class", "active"));
    }

    public TabInformation setFieldKeywords(String keywords) {
        WebElement fieldKeywords = driver.findElement(locatorFieldKeywords);
        setText(fieldKeywords, keywords);
        return this;
    }

    public TabInformation setFieldShortDescription(String shortDescription) {
        WebElement fieldShortDescription = driver.findElement(locatorFieldShortDescription);
        setText(fieldShortDescription, shortDescription);
        return this;
    }

    public TabInformation setFieldDescription(String description) {
        WebElement fieldDescription = driver.findElement(locatorFieldDescription);
        setText(fieldDescription, description);
        return this;
    }


}
