package pages.storePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class CreateAccountPage extends BasePage {

    private final By locatorPageTitle = By.xpath("//h1[(text()='Create Account')]");
    private final By locatorFieldFirstName = By.cssSelector("input[name=firstname]");
    private final By locatorFieldLastName = By.cssSelector("input[name=lastname]");
    private final By locatorFieldAddress1 = By.cssSelector("input[name=address1]");
    private final By locatorFieldPostcode = By.cssSelector("input[name=postcode]");
    private final By locatorFieldCity = By.cssSelector("input[name=city]");
    private final By locatorFieldCountry = By.cssSelector("span.select2-selection__rendered");
    private final By locatorListCountry = By.cssSelector("select[name=country_code]");
    private final By locatorFieldState = By.cssSelector("select[name=zone_code]");
    private final By locatorFieldEmail = By.cssSelector("input[name=email]");
    private final By locatorFieldPhone = By.cssSelector("input[name=phone]");
    private final By locatorCheckboxSubscribe = By.xpath("//label[./input[@name='newsletter']]");
    private final By locatorFieldDesiredPassword  = By.cssSelector("input[name=password]");
    private final By locatorFieldConfirmPassword = By.cssSelector("input[name=confirmed_password]");
    private final By locatorButtonSubmit = By.cssSelector("button[type=submit]");



    public CreateAccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorPageTitle));
    }

    public CreateAccountPage setFieldFirstName (String firstName) {
        WebElement fieldFirstName = driver.findElement(locatorFieldFirstName);
        setText(fieldFirstName, firstName);
        return this;
    }

    public CreateAccountPage setFieldLastName (String lastName) {
        WebElement fieldLastName = driver.findElement(locatorFieldLastName);
        setText(fieldLastName, lastName);
        return this;
    }

    public CreateAccountPage setFieldAddress1 (String address1) {
        WebElement fieldAddress1 = driver.findElement(locatorFieldAddress1);
        setText(fieldAddress1, address1);
        return this;
    }

    public CreateAccountPage setFieldPostcode (String postcode) {
        WebElement fieldPostcode = driver.findElement(locatorFieldPostcode);
        setText(fieldPostcode, postcode);
        return this;
    }

    public CreateAccountPage setFieldCity (String city) {
        WebElement fieldCity = driver.findElement(locatorFieldCity);
        setText(fieldCity, city);
        return this;
    }

    public CreateAccountPage choiceCountry (String country) {
//        Не работает на Firefox. Оставлю вариан, который срабатывает на обоих браузерах
//        WebElement listCountry = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorListCountry));
//        Select objSelect = new Select(listCountry);
//        objSelect.selectByVisibleText(country);

        WebElement fieldCountry = driver.findElement(locatorFieldCountry);
        clickElement(fieldCountry);
        WebElement countryWebElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + country + "']")));
        clickElement(countryWebElem);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-selection__rendered' and text()='" + country + "']")));
        return this;
    }

    public CreateAccountPage choiceState (String state) {
        WebElement listState = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorFieldState));
        Select objSelect = new Select(listState);
        objSelect.selectByVisibleText(state);
        return this;
    }

    public CreateAccountPage setFieldEmail (String email) {
        WebElement fieldEmail = driver.findElement(locatorFieldEmail);
        setText(fieldEmail, email);
        return this;
    }

    public CreateAccountPage setFieldPhone (String phone) {
        WebElement fieldPhone = driver.findElement(locatorFieldPhone);
        setText(fieldPhone, phone);
        return this;
    }

    public CreateAccountPage switchOnCheckboxSubscribe () {
        WebElement checkboxSubscribe = driver.findElement(locatorCheckboxSubscribe);
        if (checkboxSubscribe.isEnabled() != true) clickElement(checkboxSubscribe);
        return this;
    }

    public CreateAccountPage setFieldDesiredPassword (String password) {
        WebElement fieldPassword = driver.findElement(locatorFieldDesiredPassword);
        setText(fieldPassword, password);
        return this;
    }

    public CreateAccountPage setFieldConfirmPassword (String password) {
        WebElement fieldPassword = driver.findElement(locatorFieldConfirmPassword);

        setText(fieldPassword, password);
        return this;
    }

    public MainPage clickButtonSubmit () {
        WebElement buttonSubmit = driver.findElement(locatorButtonSubmit);
        clickElement(buttonSubmit);
        return new MainPage(driver);
    }

}
