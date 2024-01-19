package Zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak10 {
    public static void main(String[] args) {


        //Zadatak 10
        //Otici na stranicu https://imgflip.com/memegenerator
        //Uploadovati sliku od koje treba napraviti mim
        //Mim mora biti vezan za IT, QA ili kurs
        //Sliku rucno skinuti i ubaciti na Slack thread poruku
        //Autor mima sa najvise lajkova dobija pivo na druzenju
        //
        //Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati i ne treba raditi sa anotacijama

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://imgflip.com/memegenerator/");

        WebElement uploadNewTemplateButton = driver.findElement(By.id("mm-show-upload"));
        WebElement generateMemeButton = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        WebElement topTextInputField = driver.findElement(By.cssSelector("textarea[placeholder='Top Text']"));

        WebElement wikipediaButton = driver.findElement(By.cssSelector("button[type='submit']"));

//        generateMemeButton.click();


        String imageLocation = "A:\\QA TESTIRANJE KURS\\IT Bootcamp\\Automation\\leonardo.jpg";

        WebElement button = driver.findElement(By.id("inputImage"));

        button.sendKeys(imageLocation);

        topTextInputField.sendKeys("test");



    }
}
