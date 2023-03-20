package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LoginSteps {

    LoginPage loginvalid = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("users enter {string} and {string}")
    public void users_enter_and(String username, String password) {
        loginvalid.username.sendKeys(username);
        loginvalid.password.sendKeys(password);

    }

    @When("users click the login button")
    public void users_click_the_login_button() {
        loginvalid.loginButton.click();
    }


    @When("users hit the enter button from keyboard")
    public void users_hit_the_enter_button_from_keyboard() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("users should be on the dashboard")
    public void users_should_be_on_the_dashboard() {

        String expectedUrl = "https://qa.seamlessly.net/index.php/apps/dashboard/#/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

    }
}
