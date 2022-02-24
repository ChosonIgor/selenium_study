package pages.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.adminPages.AdminPage;

public class AuthorizationPage extends BasePage {

    private final By locatorFieldUsername = By.cssSelector("tr input[name='username']");
    private final By locatorFieldPassword = By.cssSelector("tr input[name='password']");
    private final By locatorCheckbox = By.cssSelector("tr input[name='checkbox']");
    private final By locatorButton = By.cssSelector("button[type='submit']");

    WebElement fieldUsername;
    WebElement fieldPassword;
    WebElement checkbox;
    WebElement button;

    public AuthorizationPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
//        Небольшое допущения: Появилась кнопка - загрузилась страница; кнопка не меняется при каких-либо действиях на странице
        button = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorButton));
    }

    public void setFieldUsername(String username) {
        fieldUsername = driver.findElement(locatorFieldUsername);
        setText(fieldUsername, username);
    }

    public void setFieldPassword(String password) {
        fieldPassword = driver.findElement(locatorFieldPassword);
        setText(fieldPassword, password);
    }

    public void clickCheckbox() {
        checkbox = driver.findElement(locatorCheckbox);
        clickElement(checkbox);
    }

    public AdminPage submit() {
        clickElement(button);
        return new AdminPage(driver);
    }

    public AdminPage authorization(String username, String password) {
        setFieldUsername(username);
        setFieldPassword(password);
        return submit();
    }
}
