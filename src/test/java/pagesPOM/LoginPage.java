package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    //elements
    @FindBy(id ="user-name")
    private WebElement userNameInput;

    @FindBy(id ="password")
    private WebElement passwordInput;

    @FindBy(id ="login-button")
    private WebElement loginBtn;

    //constructor
    public LoginPage(WebDriver driver){
        super(driver);
        //returns a Page Object with fully initialized fields.
        PageFactory.initElements(driver, this);
    }

    //methods i.e. actions on the page
    public ProductPage login(String username, String password){
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductPage(driver);
    }
}
