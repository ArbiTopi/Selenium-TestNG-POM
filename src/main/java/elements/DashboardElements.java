package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.util.List;

public class DashboardElements {

    public DashboardElements(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }


    @FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    public WebElement electronicButton;

    @FindBy(xpath = "(//a[normalize-space()='Cell phones'])[1]")
    public WebElement cellphonesButton;

    @FindBy(css = "div[class='page-title'] h1")
    public WebElement cellphoneText;

    @FindBy(css = "#products-orderby")
    public WebElement productOrder;

    @FindBy(xpath = "//select[@id='products-orderby']/option[contains(text(),'Price: Low to High')]")
    public WebElement lowToHigh;

    @FindBy(xpath = "(//div[@class='prices'])")
    public List<WebElement> prices;

    @FindBy(xpath = "(//button[@title='Add to wishlist'][normalize-space()='Add to wishlist'])")
    public List<WebElement> wishlistButton;

    @FindBy(css = ".bar-notification.success")
    public WebElement sucessMessage;

   @FindBy(css = ".wishlist-qty")
    public WebElement wishlistQuantity;

   @FindBy(css = ".wishlist-label")
    public WebElement wishlistBtn;

   @FindBy(xpath = "(//input[@name='addtocart'])")
    public List<WebElement> wishlistCheckBox;

   @FindBy(css = "button[name='addtocartbutton']")
    public WebElement addToCart;

   @FindBy(css = ".cart-qty")
    public WebElement cartQuantity;



}
