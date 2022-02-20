package pages.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MainPage extends BasePage {

    private final By locatorLogo = By.cssSelector("div#logotype-wrapper");
    private final String locatorProduct = "div#box-%s ul > li:nth-child(%s)";
    private final By locatorProductName = By.cssSelector("div a > div.name");
    private final By locatorProductRegularPrice = By.cssSelector("div a .regular-price");
    private final By locatorProductCampaignPrice  = By.cssSelector("div a .campaign-price");

    public MainPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorLogo));
    }

    private final By locatorListProduct = By.cssSelector("li.product");

    public List<WebElement> getListProduct() {
       return driver.findElements(locatorListProduct);
    }

    public void checkExistAStickerInProduct(WebElement product) {
        List<WebElement> numberOfStickers = product.findElements(By.xpath(".//div[contains(@class, 'sticker')]"));
        if (numberOfStickers.size() != 1) {
            System.out.println("Не Один Стикер");
        }
    }

    public ProductPage clickByProduct(String category, int number) {
        driver.findElement(By.cssSelector(String.format(locatorProduct, category, number))).click();
        return new ProductPage(driver);
    }

    public String getNameProduct(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        return product.findElement(locatorProductName).getText();
    }

    public BigDecimal getRegularPriceProduct(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        String price = product.findElement(locatorProductRegularPrice).getText();
        return new BigDecimal(price.replaceAll("[^\\d-.]", ""));
    }

    public BigDecimal getCampaignPriceProduct(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        String price = product.findElement(locatorProductCampaignPrice).getText();
        return new BigDecimal(price.replaceAll("[^\\d-.]", ""));
    }

    public String getTagNameRegularPrice(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        return product.findElement(locatorProductRegularPrice).getTagName();
    }

    public String getTagNameCampaignPrice(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        return product.findElement(locatorProductCampaignPrice).getTagName();
    }

    public String getColorRegularPrice(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        return product.findElement(locatorProductRegularPrice).getCssValue("color");
    }

    public String getColorCampaignPrice(String category, int number) {
        WebElement product = driver.findElement(By.cssSelector(String.format(locatorProduct, category, number)));
        return product.findElement(locatorProductCampaignPrice).getCssValue("color");
    }




}
