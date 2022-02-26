package pages.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.math.BigDecimal;

public class ProductPage extends BasePage {

    private final By locatorLogotype = By.cssSelector("div#logotype-wrapper");
    private final By locatorProductName = By.cssSelector("h1");
    private final By locatorProductRegularPrice = By.cssSelector("div.information .regular-price");
    private final By locatorProductCampaignPrice  = By.cssSelector("div.information .campaign-price");
    private final By locatorButtonAddToCart  = By.cssSelector("button[name=add_cart_product]");
    private final By locatorNumberItemsInCart  = By.cssSelector("span.quantity");
    private final By locatorOptionsSize  = By.cssSelector("select[name='options[Size]']");
    private final By locatorCheckout = By.cssSelector("div#cart a.link");


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

    public ProductPage clickButtonAddToCart() {
        WebElement numberItems = driver.findElement(locatorNumberItemsInCart);
        int number = Integer.parseInt(numberItems.getText());
        choiceFirstSize();
        clickElement(driver.findElement(locatorButtonAddToCart));
        wait.until(ExpectedConditions.textToBePresentInElement(numberItems, String.valueOf(number + 1)));
        return this;
    }

    public void choiceFirstSize() {
        if (driver.findElements(locatorOptionsSize).size() > 0) {
            WebElement listSize = driver.findElement(locatorOptionsSize);
            Select objSelect = new Select(listSize);
            objSelect.selectByIndex(1);
        }
    }

    public MainPage clickToLogotype() {
        clickElement(driver.findElement(locatorLogotype));
        return new MainPage(driver);
    }

    public void gotoCheckout() {
        clickElement(driver.findElement(locatorCheckout));



    }


}
