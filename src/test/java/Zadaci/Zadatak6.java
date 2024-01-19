package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();


        // LOG IN

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        submitButton.click();

        // LOG OUT

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged/in/successfully/");

        WebElement submitButtonAfterLogout = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfterLogout.isDisplayed());


        // stale element se dobije kada se DOM promeni, odnosno kada se refresuje npr. Potrebno ga je ponovo definisati




    }
}
