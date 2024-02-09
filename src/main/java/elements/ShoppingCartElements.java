package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.util.List;

public class ShoppingCartElements {
    public ShoppingCartElements(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

     @FindBy(css =".cart-label")
    public WebElement cartMenu;
    @FindBy(css =".button-1.cart-button")
    public WebElement goToCard;

    @FindBy(css = "div[class='page-title'] h1")
    public WebElement cartTextTitle;

    @FindBy(css = "#updatecart")
    public WebElement updateCartBtn;

    @FindBy(css = "button[name='continueshopping']")
    public WebElement continueShoppingBtn;

    @FindBy(css = "#open-estimate-shipping-popup")
    public WebElement estimateShippingBtn;

    @FindBy(css = "span[class='product-subtotal']")
    public List<WebElement> itemsPrices;

    @FindBy(css = "span[class='value-summary'] strong")
    public WebElement totalPrice;
}
