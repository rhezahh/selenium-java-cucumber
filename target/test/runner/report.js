$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/booking.feature");
formatter.feature({
  "name": "Booking",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Booking - Book a kost with filter 24 hours",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@booking"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"jambu\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.CommonSteps.user_navigates_to(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on Enter button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_Enter_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user login as Tenant via phone number \"rheza tenant\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CommonSteps.user_login_as_Tenant_via_phone_number(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user search area with value \"Jakarta\"",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_search_area(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on Mamikos Promo Ngebut pop up",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_Mamikos_Promo_Ngebut_pop_pup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click filter kos with \"Akses 24 Jam\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_filter_kos_with(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user turn on the booking langsung filter",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_turn_on_the_booking_langsung_filter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on kost list",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_kost_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user dismiss ftue screen pop up",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_dismiss_ftue_screen_pop_up()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on ajukan sewa button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_ajukan_sewa_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on terms and condition button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_terms_and_condition_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on ajukan sewa in booking confirmation page",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_ajukan_sewa_in_booking_confirmation_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click chat pemilik kos",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_chat_pemilik_kos()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validate text messages has sent \"Halo Bapak/Ibu Test Auto Activate.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CommonSteps.user_validate_text_messages_has_sent(java.lang.String)"
});
formatter.result({
  "error_message": "org.openqa.selenium.UnhandledAlertException: unexpected alert open: {Alert text : TypeError: Cannot read property \u0027data\u0027 of undefined}\n  (Session info: chrome\u003d90.0.4430.93): TypeError: Cannot read property \u0027data\u0027 of undefined\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Mamikoss-MacBook-Pro.local\u0027, ip: \u0027fe80:0:0:0:c86:1106:e591:4bad%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.16\u0027, java.version: \u002713.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 90.0.4430.93, chrome: {chromedriverVersion: 90.0.4430.24 (4c6d850f087da..., userDataDir: /var/folders/1r/f6_96l4j4s3...}, goog:chromeOptions: {debuggerAddress: localhost:50469}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: ba5a5c244dd985b10dee8d0e78841fa2\n*** Element info: {Using\u003dclass name, value\u003dmessage-item}\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:120)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByClassName(RemoteWebDriver.java:412)\n\tat org.openqa.selenium.By$ByClassName.findElement(By.java:389)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.AjaxElementLocator.access$001(AjaxElementLocator.java:39)\n\tat org.openqa.selenium.support.pagefactory.AjaxElementLocator$SlowLoadingElement.isLoaded(AjaxElementLocator.java:165)\n\tat org.openqa.selenium.support.ui.SlowLoadableComponent.get(SlowLoadableComponent.java:61)\n\tat org.openqa.selenium.support.pagefactory.AjaxElementLocator.findElement(AjaxElementLocator.java:95)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy24.isDisplayed(Unknown Source)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:314)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:43)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:300)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:297)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\n\tat utilities.SeleniumHelpers.waitTillElementIsVisible(SeleniumHelpers.java:196)\n\tat utilities.SeleniumHelpers.getText(SeleniumHelpers.java:67)\n\tat pageobjects.CommonPO.getChatMessagesText(CommonPO.java:244)\n\tat steps.CommonSteps.user_validate_text_messages_has_sent(CommonSteps.java:124)\n\tat ✽.user validate text messages has sent \"Halo Bapak/Ibu Test Auto Activate.\"(file:///Users/mamikos/Documents/Rheza/Code%20Repository/learning%20by%20doing/SelJavCum/src/test/resources/features/booking.feature:17)\n",
  "status": "failed"
});
formatter.step({
  "name": "user click on batalkan booking button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_batalkan_booking_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", "Booking - Book a kost with filter 24 hours");
formatter.after({
  "status": "passed"
});
});