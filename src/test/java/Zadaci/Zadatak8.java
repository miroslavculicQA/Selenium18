package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {

        // miroslav.culic90@gmail.com
        // ovoJeLozinkaZaWP
        //Zadatak 8
        //Testirati log in na wordpress stranicu

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        driver.get("https://wordpress.com/");

        // kredencijali
        String validUsername = "miroslav.culic90@gmail.com";
        String validPassword = "ovoJeLozinkaZaWP";

        WebElement loginButton = driver.findElement(By.linkText("Log In"));
        loginButton.click();

        WebElement usernameOrEmailField = driver.findElement(By.id("usernameOrEmail"));
        usernameOrEmailField.click();
        usernameOrEmailField.sendKeys(validUsername);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys(validPassword);
        continueButton.click();

//        Thread.sleep(3000);
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/miroslavculic90.wordpress.com/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/home/miroslavculic90.wordpress.com/");









    }
}
