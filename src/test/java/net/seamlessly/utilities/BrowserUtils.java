package net.seamlessly.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
       This method will accept int (in seconds) and execute Thread.sleep
       for given duration
        */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    /*
  This method accepts 3 arguments.
  Arg1: webdriver
  Arg2: expectedInUrl : for verify if the url contains given String.
      - If condition matches, will break loop.
  Arg3: expectedInTitle to be compared against actualTitle
   */
    public static void switchWindowAndVerify(String expectedUrl, String expectedInTitle) {

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current Url= " + Driver.getDriver().getCurrentUrl());
//5. Assert: Title contains “Etsy”
//    Lines to be pasted:
            if (Driver.getDriver().getCurrentUrl().contains(expectedUrl)) {
                break;
            }
        }
        //5. Assert:Title contains “expectedInTitle”
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
     This method accepts a String "expectedTitle" and Asserts if it is true
      */
    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(String expectedTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    /**
     * This method accepts a String "expectedTitle" and Asserts if it is true
     *
     * @param expectedInUrl
     */
    public static void verifyUrlContains(String expectedInUrl) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text ina List of String.
     *
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement> actualOptionAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a string
        List<String> actualOptionAsString = new ArrayList<>();

        for (WebElement each : actualOptionAsWebElement) {
            actualOptionAsString.add(each.getText());
        }

        return actualOptionAsString;

    }

    /**
     * This method will accept a group of radio buttons as a List of WebElement
     * it will loop through the list and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }








}