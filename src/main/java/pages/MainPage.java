package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.adminPage.AdminPage;

import java.util.List;
import java.util.NoSuchElementException;

public class MainPage extends BasePage {

    private final By locatorLogo = By.cssSelector("div#logotype-wrapper");

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

}
