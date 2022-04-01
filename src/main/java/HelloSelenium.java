import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.safaridriver().setup();
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://fortnitetracker.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Thread.sleep(5*1000);

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.className("hp-search-form__button"));

        searchBox.sendKeys("Roostmoos");


        searchButton.click();
        String contentFortniteTracker = driver.findElement(By.id("profile")).getText();
        System.out.println(contentFortniteTracker);

        driver.navigate().back();

        driver.quit();

    }
}
