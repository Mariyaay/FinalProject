package first.test;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProblemUser extends TestUtil {

    @Test
    public void problemUser(){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("error_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement productPageTitle = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertTrue(productPageTitle.isDisplayed());

        WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart.click();

        WebElement removeFromCart = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeFromCart.click(); //the button 'Remove' doesn't work

        Assert.assertTrue(addToCart.isDisplayed()); //the test will fail because the 'Remove' button doesn't work
    }
}
