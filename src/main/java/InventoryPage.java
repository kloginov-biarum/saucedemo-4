import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage {
    WebDriver driver;
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_list")
    WebElement inventoryList;
    @FindBy(className = "inventory_item")
    List<WebElement> inventoryItems;

    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }
    public int getItemsQuantity(){
        return inventoryItems.size();
    }
}
