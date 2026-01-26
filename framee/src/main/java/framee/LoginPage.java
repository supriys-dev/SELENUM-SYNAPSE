package framee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    // Private variables – only this class can access directly (Encapsulation)
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor – receives driver and wait from Test class
    // This is how objects get shared between classes
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;   // assign test class driver to this page
        this.wait = wait;       // assign test class wait to this page
    }

    // Locators – page elements are stored here (Page Object Model concept)
    private By emailField =By.xpath("//input[@name='email' and @placeholder='Enter Email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By loginButton = By.cssSelector("button[type='submit']");

    // Business method – hides low-level Selenium code from test
    // Test only calls login(), it does not know how login is done (Abstraction)
    public void login(String username, String password) {

        // Wait until email field is visible, then type username
        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(emailField));
        email.sendKeys(username);

        // Wait until password field is visible, then type password
        WebElement pass = wait.until(
                ExpectedConditions.visibilityOfElementLocated(passwordField));
        pass.sendKeys(password);

        // Wait until login button is clickable, then click
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
