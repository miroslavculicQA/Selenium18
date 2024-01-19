package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak7 {
    public static void main(String[] args) {

        // Zadatak 7
        // Testirati neuspesan log in

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        // INVALID USERNAME
        usernameField.sendKeys("stude3nt");
        passwordField.sendKeys("Password123");
        submitButton.click();

        WebElement neuspesanLoginMessage = driver.findElement(By.id("error"));
        String neuspesanLoginMessageText = neuspesanLoginMessage.getText();
        System.out.println(neuspesanLoginMessageText);
        String expectedNeuspesanLoginTextWrongUsername = "Your username is invalid!";
        neuspesanLoginMessage.isDisplayed();
        Assert.assertEquals(neuspesanLoginMessageText, expectedNeuspesanLoginTextWrongUsername);

        Assert.assertTrue(submitButton.isDisplayed());

//        driver.navigate().refresh();

//        // INVALID PASSWORD
//        usernameField.sendKeys("student");
//        passwordField.sendKeys("Password");
//        submitButton.click();
//
//        String expectedNeuspesanLoginTextWrongPassword = "Your password is invalid!";
//        Assert.assertEquals(neuspesanLoginMessageText, expectedNeuspesanLoginTextWrongPassword);
//









    }
}
