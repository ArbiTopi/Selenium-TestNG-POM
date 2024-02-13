import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import utilities.BaseInformation;

@Listeners({listeners.Listeners.class})
public class DashboardTest {
    private final WebDriver driver = BaseInformation.getDriver();

    DashboardPage dashboardPage = new DashboardPage();

    @Test(priority = 0,groups = {"dashboard"},dependsOnGroups = {"verifyLogin"})
    public void cellPhonePage() throws InterruptedException {
        Thread.sleep(5000);
        dashboardPage.hoverElectronic();
        Thread.sleep(5000);
        dashboardPage.clickCellphones();
        Thread.sleep(5000);
        Assert.assertTrue(dashboardPage.verifyPage(),"Worng Page");
    }
    @Test(priority = 1,groups = {"dashboard"},dependsOnGroups = {"verifyLogin"})
    public void orderPage() throws InterruptedException {
        dashboardPage.orderProduct();
        Thread.sleep(5000);
        Assert.assertTrue(dashboardPage.verifySortedCPitems(),"Prices are not sorted");
        dashboardPage.addToWishList();


    }

    @Test(priority = 2,groups = {"dashboard"},dependsOnGroups = {"verifyLogin"})
    public void addWishlist() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(dashboardPage.wishListNr(),"Not the same nr wishlist");

    }
    @Test(priority = 3,groups = {"dashboard"},dependsOnGroups = {"verifyLogin"})
    public void movingToCart(){
        dashboardPage.wishlistClick();
       dashboardPage.checkingWishlist();
       dashboardPage.addingToCart();
      Assert.assertTrue(dashboardPage.checkingQuantity(),"Something is wrong at quantity");
    }
}
