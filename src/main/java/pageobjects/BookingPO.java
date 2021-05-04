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

public class BookingPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public BookingPO(WebDriver driver) {
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
    @FindBy(xpath = "//*[@id=\"bookingDetailCard\"]/div[1]/div[2]/div[4]/button")
    private WebElement batalkanBookingButton;

    @FindBy(className = "detail-booking")
    private WebElement detailBookingCard;

    @FindBy(className = "ic-close")
    private WebElement backButton;

    @FindBy(className = "ic-minimize")
    private WebElement closeChatRoomButton;

    @FindBy(xpath = "//*[contains(text(), 'Ya, Batalkan')]")
    private List<WebElement> yaBatalkanButton;

    @FindBy(className = "text-primary")
    private WebElement lihatSelengkapnya;

    @FindBy(className = "message-item")
    private WebElement textMessages;

    @FindBy(css = ".booking-card__booking-action")
    private WebElement bookingButton;

    @FindBy(className = "booking-action--btn")
    private WebElement bookingButtonV2;

    @FindBy(id = "mamiCheckboxCommon")
    private WebElement termsAndConditions;

    @FindBy(className = "booking-success__button-chat")
    private WebElement chatOwnerKostButton;

    private By dateTextBox = By.xpath("//input[@class='booking-input-checkin__input']");

    @FindBy(xpath = "(//span[@class='cell day today'])[2]")
    private WebElement datePickToday;

    @FindBy(xpath = "(//span[@class='cell day'])[1]")
    private WebElement datePickTomorrow;

    @FindBy(xpath = "//label[@class='--failed']")
    private List<WebElement> canceledLabel;

    @FindBy(className = "kost-title")
    private List<WebElement> kostTitleLabel;

    /**
     * Click on Batalkan Booking Button
     * @throws InterruptedException
     */
    public void clickOnBatalkanBooking() throws InterruptedException {
        selenium.clickOn(backButton);
        selenium.clickOn(closeChatRoomButton);
        selenium.clickOn(lihatSelengkapnya);
        selenium.pageScrollUsingCoordinate(0, 900);
        selenium.hardWait(3);
        selenium.clickOn(batalkanBookingButton);
        selenium.clickOn(yaBatalkanButton.get(1));
        selenium.refreshPage();
    }

    /**
     * Get Text Message Value
     * @return string
     */
    public String getChatMessagesText(){
        return selenium.getText(textMessages).substring(0,34);
    }

    /**
     * Click on Booking Button
     */
    public void clickOnBookingButton() {
        selenium.pageScrollInView(bookingButton);
        selenium.waitTillElementIsClickable(bookingButton);
        selenium.javascriptClickOn(bookingButton);
    }

    /**
     * Click on Booking Button
     * @throws InterruptedException
     */
    public void clickOnBookingButtonV2() throws InterruptedException {
        selenium.clickOn(bookingButtonV2);
    }

    /**
     * Click on terms and condition checkbox
     */
    public void clickOnTermsAndConditionButton() {
        selenium.pageScrollInView(termsAndConditions);
        selenium.javascriptClickOn(termsAndConditions);
    }

    /**
     * Click on Chat Pemilik Kost Button
     * @throws InterruptedException
     */
    public void clickChatOwnerKostButton() throws InterruptedException {
        selenium.clickOn(chatOwnerKostButton);
    }

    /**
     * Select date for start boarding
     * @param date
     * @throws InterruptedException
     */
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

    /**
     * Select rent type duration
     * @param type
     */
    public void selectRentType(String type) {
        selenium.javascriptClickOn(By.xpath("//div[@class='booking-rent-type__options']/div[@class='booking-rent-type__options-item']/div[contains(.,'"+type+"')]"));
    }

    /**
     * Get Status Booking
     * @return string
     */
    public String getCanceledLabel(){
        selenium.waitInCaseElementVisible(canceledLabel.get(0), 3);
        return selenium.getText(canceledLabel.get(0));
    }

    /**
     * Get Kost Name
     * @return string
     */
    public String getKostNameLabel(){
        return selenium.getText(kostTitleLabel.get(0));
    }
}
