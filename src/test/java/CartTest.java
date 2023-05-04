import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest{

    @Test
    public void successAdding1Item(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(1, cartPage.getItemsQuantity());
    }

    @Test
    public void successAdding3Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //add 3 items to the cart
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTshirtAddToCart();
        //assert that 3 items in the cart
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(3, cartPage.getItemsQuantity());
    }

}
