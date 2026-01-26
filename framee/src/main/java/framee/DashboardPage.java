package framee;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    // Private variables for this page
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor – again receive same driver & wait from test
    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locator for search box
    private By searchInput = By.xpath("//input[@type='search']");

    // Business method for searching
    public void search(String text) {

        // Wait until search box is clickable
        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(searchInput));

        // Click inside search box
        searchBox.click();

        // Type text passed from test method
        searchBox.sendKeys(text);

        // Press ENTER key
        searchBox.sendKeys(Keys.ENTER);
    }
}
