package framee;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

    // These variables are PROTECTED so child classes (LoginTest) can use them
    protected WebDriver driver;        
    protected WebDriverWait wait;      
    protected Properties prop;         

    // This method runs BEFORE every @Test method (TestNG lifecycle)
    @BeforeMethod
    public void setUp() throws Exception {

        // Create Properties object to read data from config.properties
        prop = new Properties();

        // Load config.properties file from src/test/resources folder
        // getClass().getClassLoader() finds files from classpath (best practice)
        prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

        // Setup Chrome driver automatically (no exe path needed)
        WebDriverManager.chromedriver().setup();

        // Create Chrome browser instance
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        // Maximize browser window
        driver.manage().window().maximize();

        // Create explicit wait object (shared across pages & tests)
        // Old Selenium 3 style – works with low Java version
        wait = new WebDriverWait(driver, 30);

        // Open application URL from config.properties
        driver.get(prop.getProperty("url"));
    }

    // This method runs AFTER every @Test method
    @AfterMethod
    public void tearDown() {

        // Close browser if it is open
        if (driver != null) {
            driver.quit();
        }
    }
}
