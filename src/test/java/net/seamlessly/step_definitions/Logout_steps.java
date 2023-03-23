package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.BasePage;
import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Logout_steps extends BasePage {

    @Given("user logged in")
    public void user_logged_in() {
        loginMethod(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
    }

    @When("user clicks on the avatar image dropdown")
    public void user_clicks_on_the_avatar_image_dropdown() {
        avatarImage.click();
    }

    @When("user clicks on the Log out button")
    public void user_clicks_on_the_log_out_button() {
        logoutButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("user can go back to the login page")
    public void user_can_go_back_to_the_login_page() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }

    @When("user logged out successfully")
    public void user_logged_out_successfully() {
        logoutMethod();

    }
    @When("user clicks on step back button")
    public void user_clicks_on_step_back_button() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.BACK_SPACE);
    }
    @Then("user can not go to home page again")
    public void user_can_not_go_to_home_page_again() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }



}
