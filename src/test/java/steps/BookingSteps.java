package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.BookingPO;
import pageobjects.CommonPO;
import utilities.JavaHelpers;
import utilities.ThreadManager;

import java.text.ParseException;


public class BookingSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private BookingPO bookingPO = new BookingPO(driver);
    private CommonPO commonPO = new CommonPO(driver);
    private JavaHelpers java = new JavaHelpers();

    @When("user click on terms and condition button")
    public void user_click_on_terms_and_condition_button() {
        bookingPO.clickOnTermsAndConditionButton();
    }

    @And("user click on ajukan sewa button")
    public void user_click_on_ajukan_sewa_button() throws InterruptedException, ParseException {
        String tomorrow = java.updateTime("yyyy MMM dd", java.getTimeStamp("yyy MMM dd"), "d", 1, 0, 0, 0);
        commonPO.scrollToKostName();
        bookingPO.selectDateForStartBoarding(tomorrow);
        bookingPO.selectRentType("Per bulan");
        bookingPO.clickOnBookingButton();
    }

    @And("user click on ajukan sewa in booking confirmation page")
    public void user_click_on_ajukan_sewa_in_booking_confirmation_page() throws InterruptedException {
        bookingPO.clickOnBookingButtonV2();
    }

    @And("user click chat pemilik kos")
    public void user_click_chat_pemilik_kos() throws InterruptedException {
        bookingPO.clickChatOwnerKostButton();
    }

    @Then("user validate text messages has sent {string}")
    public void user_validate_text_messages_has_sent(String message) {
        Assert.assertEquals(bookingPO.getChatMessagesText(), message, "Messages is not contains " + message);
    }

    @And("user click on batalkan booking button")
    public void user_click_on_batalkan_booking_button() throws InterruptedException {
        bookingPO.clickOnBatalkanBooking();
    }

    @Then("user validate the booking was successfully {string} on {string}")
    public void user_validate_the_booking_was_successfully_canceled(String status, String kostName) {
        Assert.assertEquals(bookingPO.getCanceledLabel(), status, "Status is not equal to " + status);
        Assert.assertEquals(bookingPO.getKostNameLabel(), status, "Kost name is not equal to " + kostName);
    }
}
