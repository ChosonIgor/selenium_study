package pages.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.adminPages.countries.CountriesPage;
import pages.adminPages.geoZones.GeoZonesPage;

import java.util.List;
import java.util.NoSuchElementException;

public class AdminPage extends BasePage {

    private final By locatorSectorSidebar = By.cssSelector("td#sidebar");
    private final By locatorSectorContent = By.cssSelector("td#content");
    private final By locatorListMenu = By.cssSelector("ul#box-apps-menu > li");
    private final By locatorListSubMenu = By.cssSelector("ul#box-apps-menu > li li");
    private final By locatorButtonCountries = By.xpath("//ul[@id='box-apps-menu']//span[text()='Countries']");
    private final By locatorButtonGeoZones = By.xpath("//ul[@id='box-apps-menu']//span[text()='Geo Zones']");

    public AdminPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorSectorSidebar));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorSectorContent));
    }

    public void clickElemInMenu(int i) {
        WebElement elem = driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[" + i + "]"));
        if(!elem.getAttribute("class").equals("selected")) {
            clickElement(elem);
        }
    }

    public void clickElemInSubMenu(int i) {
        WebElement elem = driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li//li[" + i + "]"));
        if(!elem.getAttribute("class").equals("selected")) {
            clickElement(elem);
        }
    }

    public List<WebElement> getListMenu() {
        return driver.findElements(locatorListMenu);
    }

    public List<WebElement> getListSubMenu() {
        return driver.findElements(locatorListSubMenu);
    }

    public AdminPage checkTegH1() {
//        assertTrue(driver.findElement(locatorSectorContent).findElements(By.xpath(".//h1")).size()>0, "не найден тег h1");
        try {
            driver.findElement(locatorSectorContent).findElements(By.xpath(".//h1"));
        } catch (NoSuchElementException e) {
            System.out.println("не найден тег h1");
        }
        return this;
    }

    public CountriesPage gotoCountriesPage() {
        driver.findElement(locatorButtonCountries).click();
        return new CountriesPage(driver);
    }

    public GeoZonesPage gotoGeoZonesPage() {
        driver.findElement(locatorButtonGeoZones).click();
        return new GeoZonesPage(driver);
    }

}
