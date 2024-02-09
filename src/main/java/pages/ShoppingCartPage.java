package pages;

import elements.ShoppingCartElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;
import elements.ShoppingCartElements;

public class ShoppingCartPage {
    public ShoppingCartPage() {
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    ShoppingCartElements shoppingCartElements = new ShoppingCartElements();

    Actions actions = new Actions(BaseInformation.getDriver());

    public void hoverCart(){
        actions.moveToElement(shoppingCartElements.cartMenu).build().perform();
    }
    public void checkingGoToBtn(){
        if(shoppingCartElements.goToCard.isDisplayed())
            shoppingCartElements.goToCard.click();
    }
    public boolean checkingPage(){
        if(shoppingCartElements.cartTextTitle.getText().contains("Shopping cart"))
            return true;

        if(shoppingCartElements.updateCartBtn.isDisplayed()&&
        shoppingCartElements.estimateShippingBtn.isDisplayed()&&
        shoppingCartElements.continueShoppingBtn.isDisplayed()){
            return true;
        }
        return false;
    }

    public boolean checkingPrice(){
        double total = 0;
        for (WebElement price : shoppingCartElements.itemsPrices) {
            String numericPrice = price.getText().replaceAll("[^0-9.]", "");
            total += Double.parseDouble(numericPrice);
         }
            String finalPrice = shoppingCartElements.totalPrice.getText().replaceAll("[^0-9.]", "");
            double finalTotalPrice = Double.parseDouble(finalPrice);
        return finalTotalPrice==total;
    }
}
