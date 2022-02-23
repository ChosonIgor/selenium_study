package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    protected void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void checkSortedList(List<String> checkedList) {
        for (int i = 0; i < checkedList.size() - 1; i++) {
            if (checkedList.get(i).compareTo(checkedList.get(i+1)) > 0) {
                System.out.println(checkedList.get(i) + " и " + checkedList.get(i+1) + "расположены не в алфавитном порядке");
            }
        }
    }
}
