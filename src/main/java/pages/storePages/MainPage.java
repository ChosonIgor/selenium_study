package pages.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.math.BigDecimal;
import java.util.List;

public class MainPage extends BasePage {

    private final By locatorLogo = By.cssSelector("div#logotype-wrapper");
    private final String locatorProduct = "div#box-%s ul > li:nth-child(%s)";
    private final By locatorProductName = By.cssSelector("div a > div.name");
    private final By locatorProductRegularPrice = By.cssSelector("div a .regular-price");
    private final By locatorProductCampaignPrice  = By.cssSelector("div a .campaign-price");
    private final By locatorLinkNewCustomers = By.cssSelector("div#box-account-login a");
    private final By locatorLinkLogout = By.xpath("//div[@id='page-wrapper']//a[text()='Logout']");
    private final By locatorFieldEmailAddress = By.cssSelector("input[name=email]");
    private final By locatorFieldPassword = By.cssSelector("input[name=password]");
    private final By locatorButtonLogin = By.cssSelector("button[name=login]");


    public MainPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorLogo));
    }

    public MainPage(WebDriver driver) {
        super(driver);
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

    public CreateAccountPage clickOnLinkNewCustomers() {
        driver.findElement(locatorLinkNewCustomers).click();
        return new CreateAccountPage(driver);
    }

    public MainPage clickOnLinkLogout() {
        clickElement(driver.findElement(locatorLinkLogout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Login']")));
        return this;
    }

    public MainPage setFieldEmailAddress (String email) {
        WebElement fieldEmail = driver.findElement(locatorFieldEmailAddress);
        setText(fieldEmail, email);
        return this;
    }

    public MainPage setFieldPassword (String password) {
        WebElement fieldPassword = driver.findElement(locatorFieldPassword);
        setText(fieldPassword, password);
        return this;
    }

    public MainPage clickButtonLogin() {
        WebElement buttonLogin = driver.findElement(locatorButtonLogin);
        clickElement(buttonLogin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Account']")));
        return this;
    }
}
