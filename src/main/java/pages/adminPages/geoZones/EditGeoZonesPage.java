package pages.adminPages.geoZones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseTable;

import java.util.ArrayList;
import java.util.List;

public class EditGeoZonesPage extends BaseTable {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Edit Geo Zone')]");

    public EditGeoZonesPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public List<String> getListColumnsValue(String nameColumn) {
        int index = getNameColumn().indexOf(nameColumn) + 1;
        List<WebElement> valueColumnList = driver.findElements(By.xpath("//tbody[./tr[@class='header']]/tr[.//a]/td[" + index + "]//option[@selected]"));
        List<String> columnsValue = new ArrayList<>();
        for (WebElement cell : valueColumnList) {
            columnsValue.add(cell.getText());
        }
        return columnsValue;
    }

}
