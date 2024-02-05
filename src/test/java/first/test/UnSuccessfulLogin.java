package first.test;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnSuccessfulLogin extends TestUtil {

    @Test(dataProvider = "wrongUsers")
    public void UnsuccessfulLoginTest(String username, String password){ //because a data provider will return a two-dimensional array
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        WebElement closeErrorMsgBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(closeErrorMsgBtn.isDisplayed());
    }
}
