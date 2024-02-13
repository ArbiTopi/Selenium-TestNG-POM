import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import utilities.BaseInformation;
@Listeners(listeners.Listeners.class)

public class ShoppingCartTest {

    private final WebDriver driver = BaseInformation.getDriver();

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test(priority = 1,groups = {"shopping"},dependsOnGroups = {"dashboard"})
    public void ShoppingCartMenu(){
        shoppingCartPage.hoverCart();
        shoppingCartPage.checkingGoToBtn();
    }
    @Test(priority = 2,groups = {"shopping"},dependsOnGroups = {"dashboard"})
    public void checkingShoppingPage(){
        Assert.assertTrue(shoppingCartPage.checkingPage(),"Wrong Page");

    }
    @Test(priority = 3,groups = {"shopping"},dependsOnGroups = {"dashboard"})
    public void calculatingPrices(){
        Assert.assertTrue(shoppingCartPage.checkingPrice(),"Prices are different");
    }

}
