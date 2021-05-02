package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.text.ParseException;

public class CommonSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);
    private CommonPO common = new CommonPO(driver);
    private JavaHelpers java = new JavaHelpers();


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
        common.clickOnEnterButton();
    }

    @When("user login as Tenant via phone number {string}")
    public void user_login_as_Tenant_via_phone_number(String account) throws InterruptedException {
        String phone = "";
        String password = "";

        if(account.equalsIgnoreCase("rheza tenant")){
            phone = tenantPhoneNumber;
            password = tenantPassword;
        }
        common.loginAsTenantWithPhoneNumber(phone, password);
    }

    @And("user search property by area")
    public void user_search_property_by_area() throws InterruptedException {
        common.clickOnSearchButton();
        common.clickOnAreaTab();
    }

    @When("user click on popular city as {string}")
    public void user_click_on_popular_city_as(String city) throws InterruptedException {
        common.clickOnPopularCity(city);
    }

    @And("user click on Mamikos Promo Ngebut pop up")
    public void user_click_on_Mamikos_Promo_Ngebut_pop_pup() throws InterruptedException {
        common.clickOnSayaMengertiPopUp();
    }

    @When("user click filter kos with {string}")
    public void user_click_filter_kos_with(String filter) throws InterruptedException {
        common.clickOnKosRuleButton();
        common.clickOn24HourAccessCheckBox(filter);
        common.clickOnSaveButton();
    }

    @And("user turn on the booking langsung filter")
    public void user_turn_on_the_booking_langsung_filter() throws InterruptedException {
        common.clickOnBookingLangsungButton();
    }

    @When("user click on kost list")
    public void user_click_on_kost_list() throws InterruptedException {
        common.clickOnKostList();
    }

    @And("user dismiss ftue screen pop up")
    public void user_dismiss_ftue_screen_pop_up() throws InterruptedException {
        common.dismissFTUEScreen();
    }

    @And("user search area with value {string}")
    public void user_search_area(String area) throws InterruptedException{
        common.searchArea(area);
    }

    @And("user click on ajukan sewa button")
    public void user_click_on_ajukan_sewa_button() throws InterruptedException, ParseException {
        String tomorrow = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        common.scrollToKostName();
        common.selectDateForStartBoarding(tomorrow);
        common.selectRentType("Per bulan");
        common.clickOnBookingButton();
    }

    @When("user click on terms and condition button")
    public void user_click_on_terms_and_condition_button() throws InterruptedException {
        common.clickOnTermsAndConditionButton();
    }

    @And("user click on ajukan sewa in booking confirmation page")
    public void user_click_on_ajukan_sewa_in_booking_confirmation_page() throws InterruptedException {
        common.clickOnBookingButtonV2();
    }

    @And("user click chat pemilik kos")
    public void user_click_chat_pemilik_kos() throws InterruptedException {
        common.clickChatOwnerKostButton();
    }

    @Then("user validate text messages has sent {string}")
    public void user_validate_text_messages_has_sent(String message) throws InterruptedException {
        Assert.assertEquals(common.getChatMessagesText(), message, "Messages is not contains " + message);
        selenium.hardWait(10);
    }

    @And("user click on batalkan booking button")
    public void user_click_on_batalkan_booking_button() throws InterruptedException {
        common.clickOnBatalkanBooking();
    }
}
