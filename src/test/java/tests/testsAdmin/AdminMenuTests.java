package tests.testsAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.adminPages.AuthorizationPage;
import pages.adminPages.AdminPage;
import tests.BaseTest;

import java.util.List;

public class AdminMenuTests extends BaseTest {

    @Test
    public void testAdminMenu() {
        AuthorizationPage authorizationPage = new AuthorizationPage(driver, url);
        AdminPage adminPage = authorizationPage.authorization(username, password);
        List<WebElement> listMenu = adminPage.getListMenu();
        for (int i = 1; i <= listMenu.size(); i++) {
            adminPage.clickElemInMenu(i);
            List<WebElement> listSubMenu = adminPage.getListSubMenu();
            if (listSubMenu.size() > 0) {
                for (int j = 1; j <= listSubMenu.size(); j++) {
                    adminPage.clickElemInSubMenu(j);
                    adminPage.checkTegH1();
                }
            }
            adminPage.checkTegH1();
        }
    }
}
