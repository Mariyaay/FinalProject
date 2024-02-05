package productTestPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesPOM.LoginPage;
import pagesPOM.ProductPage;

public class ProductTest extends TestUtil {

    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver); //going to the page
        ProductPage productPage = loginPage.login("standard_user",  "secret_sauce");

        productPage.addItemToTheCart("onesie");
        // hard assert
        Assert.assertEquals(productPage.getItemsInCart(), 1, "Because only one item has been added");
    }

    @Test
    public void addItemsToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user",  "secret_sauce");

        SoftAssert softAssert = new SoftAssert();

        // adding first product to basket
        productPage.addItemToTheCart("bolt-t-shirt");
        softAssert.assertEquals(productPage.getItemsInCart(), 1, "Add first product");
        // adding second product to basket
        productPage.addItemToTheCart("backpack");
        softAssert.assertEquals(productPage.getItemsInCart(), 2, "Add second product" );

        softAssert.assertAll();
    }
}
