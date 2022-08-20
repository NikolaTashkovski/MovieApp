package nikola.tashkovski;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebsiteMenuTabs {

    public WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void testMenu() {
        driver.get("https://www.rottentomatoes.com/");

        String title = driver.getTitle();
        assertEquals("Rotten Tomatoes: Movies | TV Shows | Movie Trailers | Reviews - Rotten Tomatoes", title);

        List<WebElement> menuItems = driver.findElements(By.cssSelector(".masthead__menu-header-title"));
        String url = driver.getCurrentUrl();

        assertEquals(5, menuItems.size());

        assertEquals("MOVIES", menuItems.get(0).getText());
        assertEquals("TV SHOWS", menuItems.get(1).getText());
        assertEquals("RT PODCAST", menuItems.get(2).getText());
        assertEquals("NEWS", menuItems.get(3).getText());
        assertEquals("SHOWTIMES", menuItems.get(4).getText());
        assertEquals("https://www.rottentomatoes.com/", url);
    }
}
