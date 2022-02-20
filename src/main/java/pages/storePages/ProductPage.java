package pages.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.math.BigDecimal;

public class ProductPage extends BasePage {

    private final By locatorProductName = By.cssSelector("h1");
    private final By locatorProductRegularPrice = By.cssSelector("div.information .regular-price");
    private final By locatorProductCampaignPrice  = By.cssSelector("div.information .campaign-price");


    public ProductPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorProductName));
    }

    public String getNameProduct() {
        return driver.findElement(locatorProductName).getText();
    }

    public BigDecimal getRegularPriceProduct() {
        String price = driver.findElement(locatorProductRegularPrice).getText();
        return new BigDecimal(price.replaceAll("[^\\d-.]", ""));
    }

    public BigDecimal getCampaignPriceProduct() {
        String price = driver.findElement(locatorProductCampaignPrice).getText();
        return new BigDecimal(price.replaceAll("[^\\d-.]", ""));
    }

    public String getTagNameRegularPrice(String category, int number) {
        return driver.findElement(locatorProductRegularPrice).getTagName();
    }

    public String getTagNameCampaignPrice(String category, int number) {
        return driver.findElement(locatorProductCampaignPrice).getTagName();
    }

    public String getColorRegularPrice(String category, int number) {
        return driver.findElement(locatorProductRegularPrice).getCssValue("color");
    }

    public String getColorCampaignPrice(String category, int number) {
        return driver.findElement(locatorProductCampaignPrice).getCssValue("color");
    }
}
