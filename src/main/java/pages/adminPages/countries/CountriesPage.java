package pages.adminPages.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BaseTable;

import java.util.ArrayList;
import java.util.List;

public class CountriesPage extends BaseTable {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Countries')]");
    private final By locatorButtonAddNewCountry = By.cssSelector("a.button");


    public CountriesPage(WebDriver driver) {
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

    public EditCountryPage clickOnCountryByIndexList(int index) {
        driver.findElement(By.xpath("//tbody/tr[@class='row'][" + index + "]/td[5]/a")).click();
        return new EditCountryPage(driver);
    }

    public AddNewCountryPage clickButtonAddNewCountry() {
        driver.findElement(locatorButtonAddNewCountry).click();
        return new AddNewCountryPage(driver);
    }




}
