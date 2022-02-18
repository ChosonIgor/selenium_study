package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TestingTest extends BaseTest{


    @Test
    public void testingTest() {
        driver.get("https://www.google.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='q']")));
    }

    @Test
    public void checkLogin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector("tr input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("tr input[name='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("tr input[type='checkbox']")).click();
        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
        button.click();
        wait.until(ExpectedConditions.invisibilityOf(button));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notice errors']")));
    }
}
