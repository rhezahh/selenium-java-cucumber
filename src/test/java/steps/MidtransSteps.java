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

    @And("user should verify ordered item {string} and amount {string}")
    public void userShouldVerifyOrderedItemAndAmount(String item, String amount) throws InterruptedException {
        selenium.switchToIframe("snap-midtrans");
        Assert.assertEquals(midtrans.getItemNameText(), item, "Item name is not equal to " + item);
        Assert.assertEquals(midtrans.getItemAmountText(), amount, "Item amount is not equal to " + amount);
        midtrans.clickOnContinueButton();
    }

    @And("user choose {string} as a payment method")
    public void userChooseAsAPaymentMethod(String payment) throws InterruptedException {
        Assert.assertEquals(midtrans.getCreditCardPMText(), payment, "Payment method is not equal to " + payment);
        midtrans.clickOnCreditCardPM();
    }

    @When("user input credit card number {string}, expiry date {string} and cvv number {string}")
    public void userInputCreditCardNumberExpiryDateAndCvvNumber(String cardNumber, String expDate, String cvv) {
        midtrans.fillCreditCardInformation(cardNumber, expDate, cvv);
    }

    @Then("user verify pay now button is appeared")
    public void user_verify_button_is_appeared() {
        Assert.assertTrue(midtrans.isPayNowButtonAppear(), "Pay Now button is not appeared");
    }
}
