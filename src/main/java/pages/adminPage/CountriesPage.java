package pages.adminPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CountriesPage extends BasePage {

    private final By locatorPageTitle = By.xpath("//h1[contains(text(), 'Countries')]");

    public CountriesPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    private List<String> getNameColumn() {
        List<WebElement> elemsColumn = driver.findElements(By.cssSelector("tbody > tr.header > th"));
        List<String> nameColumn = new ArrayList<>();
        for (WebElement column : elemsColumn) {
            nameColumn.add(column.getText());
        }
        return nameColumn;
    }

    public List<String> getListCountries(String nameColumn) {
        int index = getNameColumn().indexOf(nameColumn) + 1;
        List<WebElement> elemsCountries = driver.findElements(By.cssSelector("tbody > tr.row > td:nth-child(" + index + ")"));
        List<String> nameCountries = new ArrayList<>();
        for (WebElement nameCountry : elemsCountries) {
            nameCountries.add(nameCountry.getText());
        }
        return nameCountries;
    }

    public void checkSortedList(List<String> checkedList) {
        for (int i = 0; i < checkedList.size() - 1; i++) {
            if (checkedList.get(i).compareTo(checkedList.get(i+1)) > 0) {
                System.out.println(checkedList.get(i) + " и " + checkedList.get(i+1) + "расположены не в алфавитном порядке");
            }
        }
    }
}
