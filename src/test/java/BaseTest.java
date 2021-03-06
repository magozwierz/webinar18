import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madzia\\Desktop\\Bootcamp\\chromedriver_win32_97\\chromedriver.exe");
        driver = new ChromeDriver();
        // maksymalizacja okna
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}