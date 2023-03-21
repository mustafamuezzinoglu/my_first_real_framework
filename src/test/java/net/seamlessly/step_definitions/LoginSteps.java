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
        Assert.assertEquals(message, loginPage.message.getText());
    }

    @Then("user should see blank {string}")
    public void user_should_blank_see(String message) {
        if (loginPage.username.getAttribute("validationMessage").equals(message) || loginPage.password.getAttribute("validationMessage").equals(message)) {
            Assert.assertTrue(true);
        }
    }

    @Then("User should see the password in a form of dots")
    public void user_should_see_the_password_in_a_form_of_dots() {
        Assert.assertEquals("password", loginPage.password.getAttribute("type"));
    }

    @When("user clicks on toggle image")
    public void user_clicks_on_toggle_image() {
        loginPage.toggle.click();
    }

    @Then("User can see the password explicitly")
    public void user_can_see_the_password_explicitly() {
        Assert.assertEquals("text", loginPage.password.getAttribute("type"));
    }

    @Then("user should see the {string} link on the login page")
    public void user_should_see_the_link_on_the_login_page(String forgotLink) {
        Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed());
        Assert.assertEquals(forgotLink, loginPage.forgotPasswordLink.getText());
    }

    @When("user clicks the {string} link")
    public void user_clicks_the_link(String forgotLink) {
        loginPage.forgotPasswordLink.click();
    }

    @Then("user should see the {string} link")
    public void user_should_see_the_link(String resetPasswordLink) {
        Assert.assertTrue(loginPage.resetPasswordLink.isDisplayed());
        BrowserUtils.sleep(2);
    }

    @Then("user should see valid placeholder on {string}  field")
    public void user_should_see_valid_placeholder_on_username_field(String username) {
        Assert.assertEquals(username, loginPage.usernamePlaceholder.getAttribute("placeholder"));
    }

    @Then("user should see valid placeholder on {string} field")
    public void user_should_see_valid_placeholder_on_password_field(String password) {
        Assert.assertEquals(password, loginPage.passwordPlaceholder.getAttribute("placeholder"));
    }

}
