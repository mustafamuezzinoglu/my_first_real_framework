package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page extends BasePage {


    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement message;

    @FindBy(css = "a.toggle-password")
    public WebElement toggle;

    @FindBy(id="lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(id="reset-password-wrapper")
    public WebElement resetPasswordLink;

    @FindBy(xpath = "//input[@placeholder='Username or email']")
    public WebElement usernamePlaceholder;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordPlaceholder;
}
