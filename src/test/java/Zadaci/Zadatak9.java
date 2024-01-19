package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak9 {
    public static void main(String[] args) throws InterruptedException {


        /*Zadatak 9
        https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        Thread.sleep(9000);

        WebElement cartBeforeAdding = driver.findElement(By.id("nav-cart-count"));

        String cartNumber = cartBeforeAdding.getText();
        Assert.assertEquals(cartNumber, "0");

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

        WebElement cartCounter = driver.findElement(By.id("nav-cart-count"));

        WebElement sucessfulMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(sucessfulMessage.isDisplayed());

        WebElement cartAfterAdding = driver.findElement(By.id("nav-cart-count"));
        cartNumber = cartAfterAdding.getText();
        Assert.assertEquals(cartNumber, "1");



        String expectedsucessfulMessage = "Added to Cart";
        Assert.assertEquals(sucessfulMessage, sucessfulMessage);



        // URL posle brisanja kolacica
//        String expectedURL = "https://www.amazon.com/cart/ref=sw_rv_inscr?app-nav-type=none&dc=df";
//        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // Tekst posle brisanja

        WebElement emptyCartMessage = driver.findElement(By.id("sc-empty-cart"));
        String expectedemptyCartMessage = "Your Amazon Cart is empty";
        Assert.assertEquals(emptyCartMessage.getText(), expectedemptyCartMessage);



    }
}
