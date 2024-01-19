package DomaciUtorak16_jan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Test5 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        // TEST 5 / Login with only navigating to logged in page URL.

        driver.get("https://practicetestautomation.com/logged-in-successfully/");

        // Poruke

        String successMessageTitleText = "Logged In Successfully";

        WebElement successfulMessage = driver.findElement(By.className("post-title"));
        WebElement logOutButton = driver.findElement(By.linkText("Log out"));

        Assert.assertEquals(successfulMessage.getText(), successMessageTitleText);
        Assert.assertTrue(logOutButton.isDisplayed());

        driver.quit();


    }
}
