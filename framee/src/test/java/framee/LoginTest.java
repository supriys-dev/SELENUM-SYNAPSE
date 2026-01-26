package framee;

import org.testng.annotations.Test;

public class LoginTest extends Base {   // Inheritance – gets Base features

    @Test
    public void testLoginAndSearch() {

        // Create object of LoginPage class
        // Pass driver & wait from Base to LoginPage
        LoginPage loginPage = new LoginPage(driver, wait);

        // Call login method
        
        // Username & password come from config.properties through prop object
        loginPage.login(
                prop.getProperty("username"),
                prop.getProperty("password")
        );

        // After login, create object of DashboardPage
        DashboardPage dashboard = new DashboardPage(driver, wait);

        // Call search method and pass text "sugar"
        dashboard.search("sugar");
    }
}
