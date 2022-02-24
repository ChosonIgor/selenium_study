package tests.testsStore;

import org.testng.annotations.Test;
import pages.storePages.CreateAccountPage;
import pages.storePages.MainPage;
import tests.BaseTest;

import static helperFunctions.HelperFunctions.getRandomEmail;

public class CreateNewCustomerTests extends BaseTest {

    @Test
    public void createNewCustomerTests() {
        String url = System.getProperty("mainPageURL");
        MainPage mainPage = new MainPage(driver, url);
        CreateAccountPage createAccountPage = mainPage.clickOnLinkNewCustomers();
        String emial = getRandomEmail();
        mainPage = createAccountPage.setFieldFirstName("Igor")
                .setFieldLastName("Kim")
                .setFieldAddress1("Some address")
                .setFieldPostcode("11111")
                .setFieldCity("Moscow")
                .choiceCountry("United States")
                .choiceState("Utah")
                .setFieldEmail(emial)
                .setFieldPhone("+12345678901")
                .switchOnCheckboxSubscribe()
                .setFieldDesiredPassword("1234567")
                .setFieldConfirmPassword("1234567")
                .clickButtonSubmit();
        mainPage.clickOnLinkLogout();
        mainPage.setFieldEmailAddress(emial)
                .setFieldPassword("1234567")
                .clickButtonLogin();
        mainPage.clickOnLinkLogout();
    }
}
