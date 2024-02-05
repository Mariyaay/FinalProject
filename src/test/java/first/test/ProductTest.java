package first.test;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductTest extends TestUtil {
    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-"; //Using Dynamic Elements

    @Test (dataProvider = "items list") //from DataProviders class
    public void AddProductToCart(String itemName){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + itemName)); //form the entire id of the element
        itemToBeAdded.click();

        WebElement shoppingCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        Assert.assertEquals(shoppingCartBadge.getText(), "1");
    }
}
