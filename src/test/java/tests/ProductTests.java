package tests;

import models.Product;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.storePages.MainPage;
import pages.storePages.ProductPage;

import java.math.BigDecimal;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductTests extends BaseTest {

    @Test
    public void checkExistsStickers() {
        String url = System.getProperty("mainPageURL");
        MainPage mainPage = new MainPage(driver, url);
        List<WebElement> listProduct = mainPage.getListProduct();
        for (WebElement product:listProduct) {
            mainPage.checkExistAStickerInProduct(product);
        }
    }

    @Test
    public void checkProductInMainAndProductPages() {
        String url = System.getProperty("mainPageURL");
        MainPage mainPage = new MainPage(driver, url);
        Product productMain = new Product();
        productMain.setName(mainPage.getNameProduct("campaigns", 1))
                .setRegularPrice(mainPage.getRegularPriceProduct("campaigns", 1))
                .setCampaignPrice(mainPage.getCampaignPriceProduct("campaigns", 1));
        mainPage.getTagNameRegularPrice("campaigns", 1);
        String tagNameRegularPriceMain = mainPage.getTagNameRegularPrice("campaigns", 1);
        String tagNameCampaignPriceMain = mainPage.getTagNameCampaignPrice("campaigns", 1);
        String[] colorRegularPriceMain = mainPage.getColorRegularPrice("campaigns", 1).replaceAll("[^\\d-,]", "").split(",");
        String[] colorCampaignPriceMain = mainPage.getColorCampaignPrice("campaigns", 1).replaceAll("[^\\d-,]", "").split(",");

        ProductPage productPage = mainPage.clickByProduct("campaigns", 1);
        Product product = new Product();
        product.setName(productPage.getNameProduct())
                .setRegularPrice(productPage.getRegularPriceProduct())
                .setCampaignPrice(productPage.getCampaignPriceProduct());
        String tagNameRegularPrice = productPage.getTagNameRegularPrice("campaigns", 1);
        String tagNameCampaignPrice = productPage.getTagNameCampaignPrice("campaigns", 1);
        String[] colorRegularPrice = productPage.getColorRegularPrice("campaigns", 1).replaceAll("[^\\d-,]", "").split(",");
        String[] colorCampaignPrice = productPage.getColorCampaignPrice("campaigns", 1).replaceAll("[^\\d-,]", "").split(",");

        try {
            assertEquals(product.getName(), productMain.getName(), "на главной странице и на странице товара не совпадает текст названия товара");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
        try {
            assertEquals(product.getRegularPrice(), productMain.getRegularPrice(), "на главной странице и на странице товара не совпадают цены (обычная)");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
        try {
            assertEquals(product.getCampaignPrice(), productMain.getCampaignPrice(), "на главной странице и на странице товара не совпадают цены (акционная)");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(tagNameRegularPriceMain, "s", "на главной странице обычная цена не зачёркнутая");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(tagNameRegularPrice, "s", "на странице товара обычная цена не зачёркнутая");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(tagNameCampaignPriceMain, "strong", "на главной странице акционная цена не жирная");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(tagNameCampaignPrice, "strong", "на странице товара акционная цена не жирная");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(colorRegularPriceMain[0], colorRegularPriceMain[1], "на главной странице обычная цена не серая");
            assertEquals(colorRegularPriceMain[0], colorRegularPriceMain[2], "на главной странице обычная цена не серая");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(colorRegularPrice[0], colorRegularPrice[1], "на странице товара обычная цена не серая");
            assertEquals(colorRegularPrice[0], colorRegularPrice[2], "на странице товара обычная цена не серая");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(colorCampaignPriceMain[1], "0", "на главной странице акционная цена не красная");
            assertEquals(colorCampaignPriceMain[2], "0", "на главной странице акционная цена не красная");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }

        try {
            assertEquals(colorCampaignPrice[1], "0", "на странице товара акционная цена не красная");
            assertEquals(colorCampaignPrice[2], "0", "на странице товара акционная цена не красная");
        } catch (AssertionError ae) {
            System.out.println(ae.getMessage());
        }
    }



}
