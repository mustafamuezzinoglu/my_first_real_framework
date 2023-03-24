package net.seamlessly.pages;

import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {



    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void loginMethod(String username, String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        userNameInputBox.sendKeys(username);
        passWordInputBox.sendKeys(password);
        loginButton.click();
    }

    public void logoutMethod(){
        avatarImage.click();
        logoutButton.click();
    }

    @FindBy(id = "user")
    public WebElement userNameInputBox;

    @FindBy(id = "password")
    public WebElement passWordInputBox;

    @FindBy(id="submit-form")
    public WebElement loginButton;

    @FindBy(id = "expand")
    public WebElement avatarImage;

    @FindBy(partialLinkText = "Log out")
    public WebElement logoutButton;

}
