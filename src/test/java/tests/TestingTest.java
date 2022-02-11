package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        driver.quit();
    }

    @Test
    public void testingTest() {
        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='q']")));
    }

    @Test
    public void checkLogin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("tr input[name='username']")).sendKeys("Choson");
        driver.findElement(By.cssSelector("tr input[name='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("tr input[type='checkbox']")).click();
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        button.click();
        wait.until(ExpectedConditions.invisibilityOf(button));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notice errors']")));
    }
}
