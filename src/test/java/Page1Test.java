import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Test1Page;
import utilities.BaseInformation;

public class Page1Test {
    private final WebDriver driver = BaseInformation.getDriver();

    Test1Page test1Page = new Test1Page();

    @Test(priority = 0)
    public void cellPhonePage() throws InterruptedException {
        Thread.sleep(5000);
        test1Page.hoverElectronic();
        Thread.sleep(5000);
        test1Page.clickCellphones();
        Thread.sleep(5000);
        Assert.assertTrue(test1Page.verifyPage(),"Worng Page");
    }
    @Test(priority = 1)
    public void orderPage() throws InterruptedException {
        test1Page.orderProduct();
        Thread.sleep(5000);
        Assert.assertTrue(test1Page.verifySortedCPitems(),"Prices are not sorted");
        test1Page.addToWishList();
      // Assert.assertTrue(test1Page.checkMesage(),"Message did not show");


    }

    @Test(priority = 2)
    public void addWishlist() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(test1Page.wishListNr(),"Not the same nr wishlist");

    }
    @Test(priority = 3)
    public void movingToCart(){
        test1Page.wishlistClick();
       test1Page.checkingWishlist();
       test1Page.addingToCart();
Assert.assertTrue(test1Page.checkingQuantity(),"Something is wrong at quantity");
    }
}
