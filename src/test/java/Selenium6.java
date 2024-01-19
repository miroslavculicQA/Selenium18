import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","miroslavculic90%7C1800042228%7CG1D54tumzlCFrpeTNrHWu1xUGjK8dKk5zfeYKOXnNsp%7Cd93541be046e28e87facc188e6a3baaf2b0ba6680651a32bc8f20536481ce67d");

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        Thread.sleep(4000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

    }
}