import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    ChromeDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/ergrevegvrg/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginWithValidData(){
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passwordInputFiled = driver.findElement(By.id("password"));
        passwordInputFiled.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryList.isDisplayed());
    }

    @Test
    public void loginWithValidDataPO(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
    }




}
