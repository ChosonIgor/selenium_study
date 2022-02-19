package tests.testsAdmin;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.adminPage.AdminPage;
import pages.adminPage.countries.EditCountryPage;
import pages.adminPage.geoZones.EditGeoZonesPage;
import pages.adminPage.geoZones.GeoZonesPage;
import tests.BaseTest;

import java.util.List;

public class GeoZonesTests extends BaseTest {

    @Test
    public void checkAlphabeticalGeoZonesInCountries() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        GeoZonesPage geoZonesPage = adminPage.gotoGeoZonesPage();
        List<String> countriesList = geoZonesPage.getListColumnsValue("Name");
        for (int i = 0; i < countriesList.size(); i++) {
            EditGeoZonesPage editGeoZonesPage = geoZonesPage.clickOnCountryByIndexList(i + 1);
            List<String> zones = editGeoZonesPage.getListColumnsValue("Zone");
            editGeoZonesPage.checkSortedList(zones);
            geoZonesPage = adminPage.gotoGeoZonesPage();
        }

    }


}
