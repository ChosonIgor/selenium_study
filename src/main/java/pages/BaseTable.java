package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BaseTable extends BasePage {

    public BaseTable(WebDriver driver) {
        super(driver);
    }

    protected List<String> getNameColumn() {
        List<WebElement> elemsColumn = driver.findElements(By.cssSelector("tbody > tr.header > th"));
        List<String> nameColumn = new ArrayList<>();
        for (WebElement column : elemsColumn) {
            nameColumn.add(column.getText());
        }
        return nameColumn;
    }
}
