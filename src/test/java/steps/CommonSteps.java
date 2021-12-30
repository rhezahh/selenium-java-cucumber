package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.BookingPO;
import pageobjects.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.text.ParseException;

public class CommonSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private CommonPO commonPO = new CommonPO(driver);

    private String accountProps = "src/test/resources/testData/rheza.properties";

    private String tenantPhoneNumber = JavaHelpers.getPropertyValue(accountProps, "tenant_phone_number");
    private String tenantPassword = JavaHelpers.getPropertyValue(accountProps, "tenant_password");


    @Given("user navigates to {string}")
    public void user_navigates_to(String url){
        if (url.equalsIgnoreCase("jambu")){
            url = Constants.JAMBU_URL;
        }
        selenium.navigateToPage(url);
    }

    @And("user click on Enter button")
    public void user_click_on_Enter_Button() throws InterruptedException {
        commonPO.clickOnEnterButton();
    }

    @When("user login as Tenant via phone number {string}")
    public void user_login_as_Tenant_via_phone_number(String account) throws InterruptedException {
        String phone = "";
        String password = "";

        if(account.equalsIgnoreCase("rheza tenant")){
            phone = tenantPhoneNumber;
            password = tenantPassword;
        }
        commonPO.loginAsTenantWithPhoneNumber(phone, password);
    }

    @And("user click on Mamikos Promo Ngebut pop up")
    public void user_click_on_Mamikos_Promo_Ngebut_pop_pup() throws InterruptedException {
        commonPO.clickOnSayaMengertiPopUp();
    }

    @When("user click filter kos with {string}")
    public void user_click_filter_kos_with(String filter) throws InterruptedException {
        commonPO.clickOnKosRuleButton();
        commonPO.clickOn24HourAccessCheckBox(filter);
        commonPO.clickOnSaveButton();
    }

    @And("user turn on the booking langsung filter")
    public void user_turn_on_the_booking_langsung_filter() throws InterruptedException {
        commonPO.clickOnBookingLangsungButton();
    }

    @When("user click on kost list")
    public void user_click_on_kost_list() throws InterruptedException {
        commonPO.clickOnKostList();
    }

    @And("user dismiss ftue screen pop up")
    public void user_dismiss_ftue_screen_pop_up() throws InterruptedException {
        commonPO.dismissFTUEScreen();
    }

    @And("user search area with value {string}")
    public void user_search_area(String area) throws InterruptedException{
        commonPO.searchArea(area);
    }
}
