package first.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  SuccessfulLogin {
    public WebDriver driver;

    @BeforeMethod //run before each test method
    public  void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod //run after each test method
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulLogin(){
        driver.get("https://www.saucedemo.com/");
        // log user
        WebElement userNameInput = driver.findElement(By.id("user-name")); //Finding by special attribute
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]")); //Finding by ordinary attribute
        loginBtn.click();

        WebElement productPageTitle = driver.findElement(By.xpath("//span[contains(text(),'Products')]")); //Searching by text
        Assert.assertTrue(productPageTitle.isDisplayed()); //Prove that we have successfully entered the page
    }
}
