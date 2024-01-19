package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak5 {
    public static void main(String[] args) {

// // Zadatak 5
//// Testirati log in stranice https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

//        WebElement testLoginPageLink = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));

        WebElement testLoginPageLink2 = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageLink2.click();

//        List<WebElement> username = driver.findElements(By.id("username"));
//        System.out.println("Lista: " + username.size());

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.click();
        usernameInputField.sendKeys(validUsername);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.click();
        passwordInputField.sendKeys(validPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();



        // ----------------------------------

        //Sada treba na 5. zadatku da dodate asertacije nakon logovanja


        String expectedtURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedtURL);

        WebElement pageTitle = driver.findElement(By.className("post-title"));
        String pageTitleText = pageTitle.getText();
        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(pageTitleText, expectedTitle);
        // Assert.assertEquals(pageTitle.getText(), expectedTitle);

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement pageText = driver.findElement(By.className("has-text-align-center"));
        String pageLoggedInText = pageText.getText();
        String expectedText = "Congratulations student. You successfully logged in!";
        Assert.assertEquals(pageLoggedInText, expectedText);
        Assert.assertEquals(pageText.getText(), "Congratulations " + validUsername+ ". You successfully logged in!");



    }
}
