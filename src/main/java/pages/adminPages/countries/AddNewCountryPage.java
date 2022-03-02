package pages.adminPages.countries;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AddNewCountryPage extends BasePage {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Add New Country')]");
    private final By locatorListLinksNewWindow = By.cssSelector("i.fa-external-link");


    public AddNewCountryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public List<WebElement> getListLinksNewWindow() {
        return driver.findElements(locatorListLinksNewWindow);
    }

    public void openAndCloseNewWindows(WebElement linkNewWindow) {
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        linkNewWindow.click();
        String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
        driver.switchTo().window(newWindow);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    private ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}
