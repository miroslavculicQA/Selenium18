import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selenium9 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }

    @Test
    public void test1() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement linkButton = driver.findElement(By.linkText("Test Login Page"));
        linkButton.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String validPassword = "Password123";
        String loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";

        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        WebElement profileTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(profileTitle.isDisplayed());

    }

    @Test
    public void test2() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement linkButton = driver.findElement(By.linkText("Test Login Page"));
        linkButton.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String invalidUsername = "student1";
        String validPassword = "Password123";
        String loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";

        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log Out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        WebElement profileTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(profileTitle.isDisplayed());

    }


}
