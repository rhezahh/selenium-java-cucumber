package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.Constants;
import utilities.SeleniumHelpers;

import java.util.List;

public class CommonPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public CommonPO(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        // This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */


    private By dateTextBox = By.xpath("//input[@class='booking-input-checkin__input']");

    @FindBy(xpath = "(//span[@class='cell day today'])[2]")
    private WebElement datePickToday;

    @FindBy(xpath = "(//span[@class='cell day'])[1]")
    private WebElement datePickTomorrow;

    @FindBy(className = "nav-login-button")
    private WebElement enterButton;

    @FindBy(className = "login-user-home")
    private WebElement loginAsTenantButton;

    @FindBy(xpath = "//*[@name='Nomor Handphone']")
    private WebElement phoneTextbox;

    @FindBy(xpath = "//*[@name='Password']")
    private WebElement passwordTextbox;

    @FindBy(className = "track-login-tenant")
    private WebElement tenantLoginButton;

    @FindBy(className = "btn-cta-label")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(), 'Area')]/parent::li")
    private WebElement areaTab;

    @FindBy(css = "button[data-path='btn_popperAction']")
    private WebElement sayaMengertiPopup;

    @FindBy(xpath = "//div[@id='baseMainFilter'][3]//button[@class='base-filter-button']")
    private WebElement kosRuleButton;

    @FindBy(xpath = "//button[@class='base-save']")
    private List<WebElement> saveButton;

    @FindBy(xpath = "//span[text() = 'Booking Langsung']/parent::button")
    private WebElement bookingLangsungButton;

    @FindBy(xpath = "//div[@class='open btn-group']//span[@class='slider round']")
    private WebElement sliderButton;

    @FindBy(className = "row")
    private List<WebElement> kostList;

    private By ftueScreenPopUpBody = By.cssSelector(".onboarding-ftue.highlighted");

    @FindBy(css = "button.btn-next")
    private WebElement continueBtn;

    private By iUnderstandButtonBy = By.xpath("//*[not(@class='modal-gender-button')]/child::*[contains(text(), 'Saya Mengerti')]");

    @FindBy(className = "bg-c-button--md")
    private WebElement fasilitasText;

    @FindBy(css = ".booking-card__booking-action")
    private WebElement bookingButton;

    @FindBy (xpath = "//input[@type='search']")
    private WebElement searchInputForm;

    @FindBy (className = "results-title")
    private WebElement resultList;

    @FindBy(css = ".name .--kost-title")
    private WebElement kostName;

    @FindBy(id = "mamiCheckboxCommon")
    private WebElement termsAndConditions;

    @FindBy(className = "booking-action--btn")
    private WebElement bookingButtonV2;

    @FindBy(className = "booking-success__button-chat")
    private WebElement chatOwnerKostButton;

    @FindBy(className = "message-item")
    private WebElement textMessages;

    @FindBy(className = "text-primary")
    private WebElement lihatSelengkapnya;

    @FindBy(className = "btn btn-success")
    private WebElement batalkanBookingButton;

    @FindBy(className = "detail-booking")
    private WebElement detailBookingCard;

    @FindBy(className = "ic-close")
    private WebElement backButton;

    @FindBy(className = "ic-minimize")
    private WebElement closeChatRoomButton;

    public void clickOnEnterButton() throws InterruptedException {
        if (selenium.waitInCaseElementVisible(enterButton, 3) != null){
            selenium.clickOn(enterButton);
        }
    }

    public void searchArea(String area)throws InterruptedException{
        selenium.clickOn(searchButton);
        selenium.enterText(searchInputForm,area,true);
        selenium.clickOn(resultList);
    }

    public void loginAsTenantWithPhoneNumber(String phone, String password) throws InterruptedException {
        selenium.clickOn(loginAsTenantButton);
        selenium.enterText(phoneTextbox, phone, false);
        selenium.enterText(passwordTextbox, password, false);
        selenium.pageScrollInView(tenantLoginButton);
        selenium.clickOn(tenantLoginButton);
        selenium.hardWait(3);
    }

    public void clickOnSearchButton() throws InterruptedException {
        selenium.waitInCaseElementVisible(searchButton,2);
        selenium.clickOn(searchButton);
    }

    public void clickOnAreaTab() throws InterruptedException {
        selenium.clickOn(areaTab);
    }

    public void clickOnPopularCity(String city) throws InterruptedException {
        selenium.clickOn(By.xpath("//div[@class='pills']//button[contains(text(), '" + city +"')]"));
    }

    public void clickOnSayaMengertiPopUp() throws InterruptedException {
        selenium.waitInCaseElementVisible(sayaMengertiPopup, 3);
        selenium.clickOn(sayaMengertiPopup);
        selenium.waitInCaseElementVisible(sayaMengertiPopup, 3);
        selenium.clickOn(sayaMengertiPopup);
    }

    public void clickOnKosRuleButton() throws InterruptedException {
        selenium.clickOn(kosRuleButton);
    }

    public void clickOn24HourAccessCheckBox(String filter) {
        selenium.javascriptClickOn(By.xpath("//span[text() = '" + filter + "']/parent::label"));
    }

    public void clickOnSaveButton() {
        selenium.javascriptClickOn(saveButton.get(3));
    }

    public void clickOnBookingLangsungButton() throws InterruptedException {
        selenium.clickOn(bookingLangsungButton);
        selenium.waitInCaseElementVisible(sliderButton, 3);
        selenium.javascriptClickOn(sliderButton);
    }

    public void clickOnKostList() throws InterruptedException {
        selenium.clickOn(kostList.get(0));
        selenium.switchToWindow(2);
    }

    public void dismissFTUEScreen() throws InterruptedException {
        selenium.waitInCaseElementVisible(continueBtn, 5);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(iUnderstandButtonBy);
    }

    public void scrollToKostName() {
        selenium.pageScrollInView(kostName);
    }

    public void selectDateForStartBoarding(String date) throws InterruptedException {
        if(selenium.waitInCaseElementPresent(dateTextBox,5)!=null){
            if(date.equalsIgnoreCase("today")){
                selenium.javascriptClickOn(dateTextBox);
                selenium.clickOn(datePickToday);
            }else {
                selenium.javascriptClickOn(dateTextBox);
                selenium.javascriptClickOn(datePickTomorrow);
            }
        }
    }

    public void selectRentType(String type) {
        selenium.javascriptClickOn(By.xpath("//div[@class='booking-rent-type__options']/div[@class='booking-rent-type__options-item']/div[contains(.,'"+type+"')]"));
    }

    public void clickOnBookingButton() throws InterruptedException {
        selenium.pageScrollInView(bookingButton);
        selenium.waitTillElementIsClickable(bookingButton);
        selenium.javascriptClickOn(bookingButton);
    }

    public void clickOnBookingButtonV2() throws InterruptedException {
        selenium.clickOn(bookingButtonV2);
    }

    public void clickOnTermsAndConditionButton() throws InterruptedException {
        selenium.pageScrollInView(termsAndConditions);
        selenium.javascriptClickOn(termsAndConditions);
    }

    public void clickChatOwnerKostButton() throws InterruptedException {
        selenium.clickOn(chatOwnerKostButton);
    }

    public String getChatMessagesText(){
        return selenium.getText(textMessages).substring(0,34);
    }

    public void clickOnBatalkanBooking() throws InterruptedException {
        selenium.clickOn(backButton);
        selenium.clickOn(closeChatRoomButton);
        selenium.clickOn(lihatSelengkapnya);
        selenium.pageScrollUsingCoordinate(0, 100);
        selenium.clickOn(batalkanBookingButton);
    }
}
