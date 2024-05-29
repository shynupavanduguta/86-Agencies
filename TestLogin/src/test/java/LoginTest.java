import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "C://Users//omshu//Downloads//chromedriver-win64//chromedriver.exe");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://app.logyxps.com/");

        // Find the email and password input fields and enter valid credentials
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));

        // Find the login button
        WebElement loginButton = driver.findElement(By.className("MuiButton-root"));

        // Enter valid email and password
        emailField.sendKeys("demomail@gmail.com");
        passwordField.sendKeys("demomail");

        // Click on the login button
        loginButton.click();

        // Wait for the landing page to load after login (you can change the locator according to your landing page)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement landingPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("landingPageElementId")));

        // Verify that the login was successful by checking for a specific element on the landing page
        if (landingPageElement.isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();
    }
}
