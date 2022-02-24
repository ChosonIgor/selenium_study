package tests.testsAdmin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.adminPages.AdminPage;
import pages.adminPages.AuthorizationPage;
import pages.adminPages.catalog.addNewProduct.AddNewProductPage;
import pages.adminPages.catalog.CatalogPage;
import tests.BaseTest;

import java.util.List;

import static helperFunctions.HelperFunctions.getNameProduct;

public class AddNewProductTests extends BaseTest {

    @Test
    public void checkAddNewProduct() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        CatalogPage catalogPage = adminPage.gotoCatalogPage();
        AddNewProductPage addNewProductPage = catalogPage.gotoAddNewProductPage();
        addNewProductPage.gotoTabGeneral();
        String name = getNameProduct();
        addNewProductPage.tabGeneral()
                .clickToStatusEnabled()
                .setFieldName(name)
                .setFieldCode("999")
                .enabledUnisexInProductGroups()
                .setFieldQuantity(1000)
                .choiceDeliveryStatus(1)
                .addPhoto()
                .setDateValidFrom("2022-02-20")
                .setDateValidTo("2023-02-20");
        addNewProductPage.gotoTabInformation();
        addNewProductPage.tabInformation()
                .setFieldKeywords("Tiger")
                .setFieldShortDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                .setFieldDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse " +
                        "sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque dui non consequat " +
                        "sollicitudin. Sed pretium tortor ac auctor molestie. Nulla facilisi. Maecenas pulvinar nibh " +
                        "vitae lectus vehicula semper. Donec et aliquet velit. Curabitur non ullamcorper mauris." +
                        " In hac habitasse platea dictumst.");

        addNewProductPage.gotoTabPrices();
        addNewProductPage.tabPrices().setFieldPurchasePrice("10.50").setFieldPriceUSD("25.00");
        catalogPage = addNewProductPage.clickButtonSave();
        List<String> listProducts = catalogPage.getListColumnsValue("Name");
        Assert.assertTrue(listProducts.contains(name));
    }
}
