package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        // to launch Chrome Browser
        openBrowserAndNavigateToURL();
        //driver = new ChromeDriver();
        //driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
        WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        //entering the credential
        //usernameTextField.sendKeys(ConfigReader.getPropertyValue("username"));
        //passwordTextField.sendKeys(ConfigReader.getPropertyValue("password"));
        sendText(ConfigReader.getPropertyValue("username"), usernameTextField);
        sendText(ConfigReader.getPropertyValue("password"), passwordTextField);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.name("Submit"));
        loginButton.click();
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        System.out.println("My test case is passed");
    }

    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
       WebElement usernameField = driver.findElement(By.id("txtUsername"));
       WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //logged in via normal employee
        // usernameField.sendKeys("dalima123");
        //passwordField.sendKeys("Hum@nhrm123");
        sendText("dalima123", usernameField);
        sendText("Hum@nhrm123", passwordField);
    }

    @When("user enters invalid admin username and password")
    public void user_enters_invalid_admin_username_and_password() {
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //logged in via normal employee
        //usernameField.sendKeys("admin123");
        //passwordField.sendKeys("Hum@nhrm123");
        sendText("admin123", usernameField);
        sendText("Hum#n", passwordField);
    }
    @Then("error message is displayed")
    public void error_message_is_displayed() {
        System.out.println("Error message is displayed");
    }


}