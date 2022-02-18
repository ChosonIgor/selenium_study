package tests;

import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.adminPage.AdminPage;
import pages.adminPage.CountriesPage;

import java.util.List;

public class CountriesPageTests extends BaseTest {

    @Test
    public void checkAlphabeticalCountries() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        CountriesPage countriesPage = adminPage.gotoCountriesPage();
        List<String> countiesList = countriesPage.getListCountries("Name");
        countriesPage.checkSortedList(countiesList);
    }


}
