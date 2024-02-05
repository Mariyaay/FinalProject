package pagesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isAt(){
        if (pageTitle.getText().equals("Products")) {
            return true;
        }else {
            return false;
        }
    }

    public void addItemToTheCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + itemName));
        itemToBeAdded.click();
    }

    public int getItemsInCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }
}
