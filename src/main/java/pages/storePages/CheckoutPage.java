package pages.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class CheckoutPage extends BasePage {

    private final By locatorTextNoItems = By.xpath("//em[text()='There are no items in your cart.']");
    private final By locatorButtonRemove = By.cssSelector("button[name=remove_cart_item]");
    private final By locatorTableOrderSummary = By.cssSelector("div#box-checkout-summary tbody");
    private final By locatorSomeValueInTableOrderSummary = By.cssSelector("table.dataTable.rounded-corners td");


    public CheckoutPage(WebDriver driver) {
        super(driver);
        wait.until(or(presenceOfElementLocated(locatorTableOrderSummary), presenceOfElementLocated(locatorTextNoItems)));
    }

    public void removeAllProducts() {
        while (driver.findElements(locatorSomeValueInTableOrderSummary).size() > 0) {
            WebElement someValueInTableOrderSummary = driver.findElement(locatorSomeValueInTableOrderSummary);
            clickElement(driver.findElement(locatorButtonRemove));
            wait.until(ExpectedConditions.stalenessOf(someValueInTableOrderSummary));
            wait.until(or(presenceOfElementLocated(locatorTableOrderSummary), presenceOfElementLocated(locatorTextNoItems)));
        }
    }






}
