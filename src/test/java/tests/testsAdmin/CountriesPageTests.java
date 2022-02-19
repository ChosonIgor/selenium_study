package tests.testsAdmin;

import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.adminPage.AdminPage;
import pages.adminPage.countries.CountriesPage;
import pages.adminPage.countries.EditCountryPage;
import tests.BaseTest;

import java.util.List;

public class CountriesPageTests extends BaseTest {

    @Test
    public void checkAlphabeticalCountries() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        CountriesPage countriesPage = adminPage.gotoCountriesPage();
        List<String> countiesList = countriesPage.getListColumnsValue("Name");
        countriesPage.checkSortedList(countiesList);
    }

    @Test
    public void checkAlphabeticalZonesInCountries() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        CountriesPage countriesPage = adminPage.gotoCountriesPage();
        List<String> zonesList = countriesPage.getListColumnsValue("Zones");
        for (int i = 0; i < zonesList.size(); i++) {
            if (!zonesList.get(i).equals("0")) {
                EditCountryPage editCountryPage = countriesPage.clickOnCountryByIndexList(i + 1);
                List<String> zones = editCountryPage.getListColumnsValue("Name");
                editCountryPage.checkSortedList(zones);
                countriesPage = adminPage.gotoCountriesPage();
            }
        }
    }
}
