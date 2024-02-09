package pages;

import elements.Test1Elements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseInformation;

import java.sql.Struct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test1Page {
    public  Test1Page(){
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }
    Test1Elements test1Elements = new Test1Elements();
    Actions actions = new Actions(BaseInformation.getDriver());
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(4));



    public void hoverElectronic(){
       actions.moveToElement(test1Elements.electronicButton).build().perform();

    }
    public void clickCellphones(){
        if(test1Elements.cellphonesButton.isDisplayed()){
        test1Elements.cellphonesButton.click();
        }
    }

    public boolean  verifyPage(){

        return test1Elements.cellphoneText.getText().equals("Cell phones");
    }
    public void orderProduct(){
        actions.moveToElement(test1Elements.productOrder).build().perform();
        test1Elements.lowToHigh.click();
    }
    public boolean verifySortedCPitems() {
             List<Double> prices = new ArrayList<>();
             String priceText = "";
             for (WebElement element : test1Elements.prices) {
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
             wait.until(ExpectedConditions.visibilityOf(test1Elements.sucessMessage));
         }

         public void addToWishList() throws InterruptedException {
        for (WebElement in : test1Elements.wishlistButton){
            WebElement clickableButton =wait.until(ExpectedConditions.elementToBeClickable(in));
            clickableButton.click();
            checkMesage();
            Thread.sleep(2000);
        }
         }
         public boolean wishListNr(){
        return test1Elements.wishlistQuantity.getText().equals("(3)");
         }
         public void wishlistClick(){
        test1Elements.wishlistBtn.click();
         }
         public void checkingWishlist(){
        for (WebElement in: test1Elements.wishlistCheckBox){
            in.click();
        }
         }
         public void addingToCart(){
        test1Elements.addToCart.click();
         }
         public boolean checkingQuantity(){

        return (test1Elements.wishlistQuantity.getText().equals("(0)")&&test1Elements.cartQuantity.getText().equals("(3)"));
         }
}