import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium7 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://crop-circle.imageonline.co/#circlecropresult");

        String imageLocation = "A:\\QA TESTIRANJE KURS\\IT Bootcamp\\Automation\\selenium.png";

        WebElement button = driver.findElement(By.id("inputImage"));

        button.sendKeys(imageLocation);


    }
}