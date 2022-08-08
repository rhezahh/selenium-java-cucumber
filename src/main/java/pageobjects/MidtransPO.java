package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;
import utilities.SeleniumHelpers;

import java.util.List;

public class MidtransPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public MidtransPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
    }

    @FindBy(xpath = "//a[text()='BUY NOW']")
    private WebElement buyNowButton;

    @FindBy(className = "cart-checkout")
    private WebElement checkoutButton;

    @FindBy(className = "item-name")
    private WebElement itemNameText;

    @FindBy(className = "text-body")
    private List<WebElement> amountText;

    @FindBy(className = "button-main-content")
    private WebElement continueButton;

    @FindBy(xpath = "//div[text() = 'Credit/Debit Card']")
    private WebElement creditCardPM;

    @FindBy(name = "cardnumber")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@placeholder = 'MM / YY']")
    private WebElement expireDateInput;

    @FindBy(xpath = "//input[@placeholder = '123']")
    private WebElement cvvInput;

    @FindBy(xpath = "//span[contains(text(), 'Pay Now')]")
    private WebElement payNowButton;



    public void clickOnBuyNowButton() throws InterruptedException {
        selenium.clickOn(buyNowButton);
    }

    public String getBuyNowButtonText(){
        return selenium.getText(buyNowButton);
    }

    public void clickOnCheckoutButton() throws InterruptedException {
        selenium.clickOn(checkoutButton);
    }

    public String getItemNameText(){
        return selenium.getText(itemNameText);
    }

    public String getItemAmountText(){
        return selenium.getText(amountText.get(1));
    }

    public void clickOnContinueButton() throws InterruptedException {
        selenium.clickOn(continueButton);
    }

    public String getCreditCardPMText(){
        return selenium.getText(creditCardPM);
    }

    public void clickOnCreditCardPM() throws InterruptedException {
        selenium.clickOn(creditCardPM);
    }

    public void fillCreditCardInformation(String number, String expDate, String cvv){
        selenium.enterText(cardNumberInput, number, false);
        selenium.enterText(expireDateInput, expDate, false);
        selenium.enterText(cvvInput, cvv, false);
    }

    public Boolean isPayNowButtonAppear(){
        return selenium.waitInCaseElementVisible(payNowButton, 3) != null;
    }

}
