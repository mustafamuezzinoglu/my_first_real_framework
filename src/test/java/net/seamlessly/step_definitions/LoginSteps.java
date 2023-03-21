package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);

    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
        BrowserUtils.sleep(2);
    }

    @When("user hit the enter button from keyboard")
    public void user_hit_the_enter_button_from_keyboard() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Then("user should be on the dashboard")
    public void user_should_be_on_the_dashboard() {
        String expectedUrl = "https://qa.seamlessly.net/index.php/apps/dashboard/#/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Then("user should see {string}")
    public void user_should_see(String message) {

        if (loginPage.username.getAttribute("validationMessage").equals(message) || loginPage.password.getAttribute("validationMessage").equals(message)) {
            Assert.assertTrue(true);
        } else if (message.equals("Wrong username or password.")) {
            Assert.assertEquals(message, loginPage.message.getText());
        }
    }

}
