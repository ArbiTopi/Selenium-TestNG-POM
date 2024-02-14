package pages;

import elements.DashboardElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseInformation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }
    DashboardElements dashboardElements = new DashboardElements();
    Actions actions = new Actions(BaseInformation.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(4));



    public void hoverElectronic(){
       actions.moveToElement(dashboardElements.electronicButton).build().perform();

    }
    public void clickCellphones(){
        if(dashboardElements.cellphonesButton.isDisplayed()){
        dashboardElements.cellphonesButton.click();
        }
    }

    public boolean  verifyPage(){

        return dashboardElements.cellphoneText.getText().equals("Cell phones");
    }
    public void orderProduct(){
        actions.moveToElement(dashboardElements.productOrder).build().perform();
        dashboardElements.lowToHigh.click();
    }
    public boolean verifySortedCPitems() {
             List<Double> prices = new ArrayList<>();
             String priceText = "";
             for (WebElement element : dashboardElements.prices) {
                 priceText = element.getText().replaceAll("[^0-9.]", ""); // Remove non-numeric characters
                 double price = Double.parseDouble(priceText);
                 prices.add(price);
             }
             boolean isSorted = true;
             for (int i = 1; i < prices.size(); i++) {
                 if (prices.get(i) < prices.get(i - 1)) {
                     isSorted = false;
                     break;
                 }
             }
             return isSorted;
         }
         public void checkMesage(){
             wait.until(ExpectedConditions.visibilityOf(dashboardElements.sucessMessage));
         }

         public void addToWishList() throws InterruptedException {
        for (WebElement in : dashboardElements.wishlistButton){
            WebElement clickableButton =wait.until(ExpectedConditions.elementToBeClickable(in));
            clickableButton.click();
            checkMesage();
            Thread.sleep(1000);
        }
         }
         public boolean wishListNr(){
        return dashboardElements.wishlistQuantity.getText().equals("(3)");
         }
         public void wishlistClick(){
             WebElement clickableButton= wait.until(ExpectedConditions.elementToBeClickable(dashboardElements.wishlistBtn));
             clickableButton.click();
         }

         public void checkingWishlist(){
        for (WebElement in: dashboardElements.wishlistCheckBox){
            WebElement clickableButton =wait.until(ExpectedConditions.elementToBeClickable(in));
            clickableButton.click();        }
         }
         public void addingToCart(){
        dashboardElements.addToCart.click();
         }
         public boolean checkingQuantity(){
        return (dashboardElements.wishlistQuantity.getText().equals("(0)")&& dashboardElements.cartQuantity.getText().equals("(3)"));
         }
}