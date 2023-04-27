import javafx.geometry.Side;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class SideBarTest extends BaseTest{
    @Test
    public void checkAllLinksAreDisplayed() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBurgerMenuBtn();
        SideBar sideBar = new SideBar(driver);
        //check All items, About, Logout,Reset App State - are enabled
        assertTrue(sideBar.allItemsIsEnabled());
        assertTrue(sideBar.aboutIsEnabled());
        assertTrue(sideBar.logoutIsEnabled());
        assertTrue(sideBar.resetAppStateIsEnabled());
        sleep(3000);
        assertTrue(sideBar.allItemsIsDisplayed());
    }
}
