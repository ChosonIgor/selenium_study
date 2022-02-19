package pages.adminPage.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.BaseTable;

import java.util.ArrayList;
import java.util.List;

public class EditCountryPage extends BaseTable {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Edit Country')]");

    public EditCountryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public List<String> getListColumnsValue(String nameColumn) {
        int index = getNameColumn().indexOf(nameColumn) + 1;
        List<WebElement> elemsCountries = driver.findElements(By.xpath("//tbody[./tr[@class='header']]/tr[.//a]/td[" + index + "]"));
        List<String> columnsValue = new ArrayList<>();
        for (WebElement nameCountry : elemsCountries) {
            columnsValue.add(nameCountry.getText());
        }
        return columnsValue;
    }





}
