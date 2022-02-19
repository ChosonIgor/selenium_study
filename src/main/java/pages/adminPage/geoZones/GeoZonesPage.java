package pages.adminPage.geoZones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.BaseTable;
import pages.adminPage.countries.EditCountryPage;

import java.util.ArrayList;
import java.util.List;

public class GeoZonesPage extends BaseTable {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Geo Zones')]");

    public GeoZonesPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public List<String> getListColumnsValue(String nameColumn) {
        int index = getNameColumn().indexOf(nameColumn) + 1;
        List<WebElement> elemsCountries = driver.findElements(By.cssSelector("tbody > tr.row > td:nth-child(" + index + ")"));
        List<String> columnsValue = new ArrayList<>();
        for (WebElement nameCountry : elemsCountries) {
            columnsValue.add(nameCountry.getText());
        }
        return columnsValue;
    }

    public EditGeoZonesPage clickOnCountryByIndexList(int index) {
        driver.findElement(By.xpath("//tbody/tr[@class='row'][" + index + "]/td[5]/a")).click();
        return new EditGeoZonesPage(driver);
    }
}
