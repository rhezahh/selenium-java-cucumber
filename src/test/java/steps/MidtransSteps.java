package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.MidtransPO;
import utilities.Constants;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class MidtransSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private MidtransPO midtrans = new MidtransPO(driver);
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url){
        if (url.equalsIgnoreCase("midtrans")){
            url = Constants.MIDTRANS_URL;
        }
        selenium.navigateToPage(url);
    }

    @And("user click {string} button")
    public void userClickButton(String text) throws InterruptedException {
        Assert.assertEquals(midtrans.getBuyNowButtonText(), text, "Button text is not equal to " + text);
        midtrans.clickOnBuyNowButton();
    }

    @When("user click on checkout button")
    public void userClickOnCheckoutButton() throws InterruptedException {
        midtrans.clickOnCheckoutButton();
    }

    @And("user choose {string} as a payment method")
    public void userChooseAsAPaymentMethod(String payment) throws InterruptedException {
        selenium.switchToIframe("snap-midtrans");
        Assert.assertEquals(midtrans.getCreditCardPMText().substring(0,17), payment, "Payment method is not equal to " + payment);
        midtrans.clickOnCreditCardPM();
    }

    @When("user input credit card number {string}, expiry date {string} and cvv number {string}")
    public void userInputCreditCardNumberExpiryDateAndCvvNumber(String cardNumber, String expDate, String cvv) {
        midtrans.fillCreditCardInformation(cardNumber, expDate, cvv);
    }

    @And("user verify pay now button is appeared")
    public void user_verify_button_is_appeared() {
        Assert.assertTrue(midtrans.isPayNowButtonAppear(), "Pay Now button is not appeared");
    }

    @Then("user click on {string} button")
    public void user_click_on_pay_now_button(String button) throws InterruptedException {
        Assert.assertEquals(midtrans.getPayNowButtonText(), button, "Button text is not equal to" + button);
        midtrans.clickPayNowButton();
    }

    @When("user input password {string} for payment")
    public void user_input_password_for_payment(String password){
        midtrans.enterPasswordforPayment(password);
    }

    @Then("user click on OK button")
    public void user_click_on_button() throws InterruptedException {
        midtrans.clickOnOkButton();
    }
}
