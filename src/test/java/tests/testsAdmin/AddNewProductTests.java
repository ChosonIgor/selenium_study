package tests.testsAdmin;

import org.testng.annotations.Test;
import pages.adminPages.AdminPage;
import pages.adminPages.AuthorizationPage;
import pages.adminPages.catalog.addNewProduct.AddNewProductPage;
import pages.adminPages.catalog.CatalogPage;
import tests.BaseTest;

public class AddNewProductTests extends BaseTest {

    @Test
    public void checkAlphabeticalCountries() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        CatalogPage catalogPage = adminPage.gotoCatalogPage();
        AddNewProductPage addNewProductPage = catalogPage.gotoAddNewProductPage();
        addNewProductPage.gotoTabGeneral();
        addNewProductPage.tabGeneral().clickToStatusEnabled()
//                .setFieldName("Tiger")
//                .setFieldCode("999")
//                .enabledUnisexInProductGroups()
//                .setFieldQuantity(1000)
//                .choiceDeliveryStatus(1)
//                .addPhoto()
                .setDateValidFrom("2022-02-20")
                ;

    }
}
