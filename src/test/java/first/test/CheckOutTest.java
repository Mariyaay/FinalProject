package first.test;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends TestUtil{
    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    @Test (dataProvider = "items list")
    public void checkOut (String itemName){
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

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + itemName));
        itemToBeAdded.click();

        WebElement shoppingCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        shoppingCartBadge.click();

        WebElement yourCartPageTitle = driver.findElement(By.xpath("//span[contains(text(), 'Your Cart')]"));
        Assert.assertTrue(yourCartPageTitle.isDisplayed());

        WebElement checkOut = driver.findElement(By.id("checkout"));
        checkOut.click();

        WebElement checkOutYourInfo = driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Your Information')]"));
        Assert.assertTrue(checkOutYourInfo.isDisplayed());
    }
}
