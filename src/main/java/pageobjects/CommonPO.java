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


    @FindBy (xpath = "//input[@type='search']")
    private WebElement searchInputForm;

    @FindBy (className = "results-title")
    private WebElement resultList;

    @FindBy(css = ".name .--kost-title")
    private WebElement kostName;

    /**
     * Click on "Masuk" Button
     * @throws InterruptedException
     */
    public void clickOnEnterButton() throws InterruptedException {
        if (selenium.waitInCaseElementVisible(enterButton, 3) != null){
            selenium.clickOn(enterButton);
        }
    }

    /**
     * Click on search button and search kost using custom value
     * @param area
     * @throws InterruptedException
     */
    public void searchArea(String area)throws InterruptedException{
        selenium.clickOn(searchButton);
        selenium.enterText(searchInputForm,area,true);
        selenium.clickOn(resultList);
    }

    /**
     * Login as Tenant with Phone Number
     * @param phone
     * @param password
     * @throws InterruptedException
     */
    public void loginAsTenantWithPhoneNumber(String phone, String password) throws InterruptedException {
        selenium.clickOn(loginAsTenantButton);
        selenium.enterText(phoneTextbox, phone, false);
        selenium.enterText(passwordTextbox, password, false);
        selenium.pageScrollInView(tenantLoginButton);
        selenium.clickOn(tenantLoginButton);
        selenium.hardWait(3);
    }

    /**
     * Click on Saya Mengerti Pop Up
     * @throws InterruptedException
     */
    public void clickOnSayaMengertiPopUp() throws InterruptedException {
        selenium.waitInCaseElementVisible(sayaMengertiPopup, 3);
        selenium.clickOn(sayaMengertiPopup);
        selenium.waitInCaseElementVisible(sayaMengertiPopup, 3);
        selenium.clickOn(sayaMengertiPopup);
    }

    /**
     * Click on Kost Rule Button
     * @throws InterruptedException
     */
    public void clickOnKosRuleButton() throws InterruptedException {
        selenium.clickOn(kosRuleButton);
    }

    /**
     * Click on 24 Hour Access Checkbox
     * @param filter
     */
    public void clickOn24HourAccessCheckBox(String filter) {
        selenium.javascriptClickOn(By.xpath("//span[text() = '" + filter + "']/parent::label"));
    }

    /**
     * Click on "Simpan" button for applied filter
     */
    public void clickOnSaveButton() {
        selenium.javascriptClickOn(saveButton.get(3));
    }

    /**
     * Click on Booking Langsung Button
     * @throws InterruptedException
     */
    public void clickOnBookingLangsungButton() throws InterruptedException {
        selenium.clickOn(bookingLangsungButton);
        selenium.waitInCaseElementVisible(sliderButton, 3);
        selenium.javascriptClickOn(sliderButton);
    }

    /**
     * Select on of kost from the kost lists
     * @throws InterruptedException
     */
    public void clickOnKostList() throws InterruptedException {
        selenium.clickOn(kostList.get(0));
        selenium.switchToWindow(2);
    }

    /**
     * Dismiss FTUE Pop up
     * @throws InterruptedException
     */
    public void dismissFTUEScreen() throws InterruptedException {
        selenium.waitInCaseElementVisible(continueBtn, 5);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(continueBtn);
        selenium.clickOn(iUnderstandButtonBy);
    }

    /**
     * Scroll to Kost Name
     */
    public void scrollToKostName() {
        selenium.pageScrollInView(kostName);
    }
}
