package loginTestPOM;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import pagesPOM.ProductPage;

public class LoginTest extends TestUtil {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productPage.isAt());
    }
}
