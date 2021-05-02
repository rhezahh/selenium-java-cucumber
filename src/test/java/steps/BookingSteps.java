package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.BookingPO;
import utilities.Constants;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class BookingSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

}
