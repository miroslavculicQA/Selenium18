package DomaciUtorak16_jan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginPageLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageLink.click();

        // Kredencijali i poruke

        String validUsername = "student";
        String validPassword = "Password123";

        String invalidUsername = "studentA";
        String invalidPassword = "Password1234";

        String invalidUsernameErrorMessage = "Your username is invalid!";
        String invalidPasswordErrorMessage = "Your password is invalid!";


        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        WebElement errorMessage = driver.findElement(By.id("error"));


        // TEST 1 / Login without any data input into username and password field.
        submitButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), invalidUsernameErrorMessage);

        driver.quit();



    }
}
