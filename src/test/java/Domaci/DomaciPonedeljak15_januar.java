package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class DomaciPonedeljak15_januar {
    public static void main(String[] args) {

        // Domaci Zadatak 2:
        // https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box/");

        WebElement fullNameField = driver.findElement(By.id("userName"));
        WebElement emailFiled = driver.findElement(By.id("userEmail"));
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        WebElement output = driver.findElement(By.id("output"));

        String fullName = "Malina Vojvodić";
        String email = "malina.vojvodic@gmail.com";
        String currentAddress = "Topolska 18";
        String permanentAddress = "Topolska 20";


        fullNameField.sendKeys(fullName);
        emailFiled.sendKeys(email);
        currentAddressField.sendKeys(currentAddress);
        permanentAddressField.sendKeys(permanentAddress);
        submitButton.click();

//        WebElement name = driver.findElement(By.id("name"));
//        WebElement email = driver.findElement(By.id("email"));
//        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
//        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
//

        String outputText = output.getText();
        String expectedOutputText = "Name:" + fullName + "\nEmail:" + email + "\nCurrent Address :" + currentAddress + "\nPermananet Address :" + permanentAddress;
        Assert.assertEquals(outputText, expectedOutputText);





    }
}
