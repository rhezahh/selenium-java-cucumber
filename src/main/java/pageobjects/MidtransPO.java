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

    @FindBy(xpath = "//div[text() = 'Credit/debit card']")
    private WebElement creditCardPM;

    @FindBy(xpath = "//input[@placeholder='1234 1234 1234 1234']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@placeholder = 'MM/YY']")
    private WebElement expireDateInput;

    @FindBy(xpath = "//input[@placeholder = '123']")
    private WebElement cvvInput;

    @FindBy(xpath = "//button[contains(text(), 'Pay now')]")
    private WebElement payNowButton;

    @FindBy(xpath = "//input[@placeholder='112233']")
    private WebElement passwordInput;

    @FindBy(className = "iframe-3ds")
    private WebElement iframe3ds;

    @FindBy(name = "ok")
    private WebElement okButton;



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

    public void clickPayNowButton() throws InterruptedException {
        selenium.waitTillElementIsClickable(payNowButton);
        selenium.clickOn(payNowButton);
    }

    public String getPayNowButtonText() throws InterruptedException {
        selenium.scrollDownToElement(payNowButton);
        return selenium.getText(payNowButton);
    }

    public void enterPasswordforPayment(String password){
        selenium.switchToIframeElement(iframe3ds);
        selenium.waitTillElementIsVisible(passwordInput);
        selenium.enterText(passwordInput, password, false);
    }

    public void clickOnOkButton() throws InterruptedException {
        selenium.clickOn(okButton);
    }
}
