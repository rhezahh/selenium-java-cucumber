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
  "error_message": "java.lang.NoSuchMethodError: \u0027void pageobjects.CommonPO.selectDateForStartBoarding(java.lang.String)\u0027\n\tat steps.CommonSteps.user_click_on_ajukan_sewa_button(CommonSteps.java:102)\n\tat ✽.user click on ajukan sewa button(file:///Users/mamikos/Documents/Rheza/Code%20Repository/learning%20by%20doing/SelJavCum/src/test/resources/features/booking.feature:13)\n",
  "status": "failed"
});
formatter.step({
  "name": "user click on terms and condition button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_terms_and_condition_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user click on ajukan sewa in booking confirmation page",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_on_ajukan_sewa_in_booking_confirmation_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user click chat pemilik kos",
  "keyword": "And "
});
formatter.match({
  "location": "steps.CommonSteps.user_click_chat_pemilik_kos()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user validate text messages has sent \"Halo Bapak/Ibu Test Auto Activate.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.CommonSteps.user_validate_text_messages_has_sent(java.lang.String)"
});
formatter.result({
  "status": "skipped"
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
formatter.step({
  "name": "user validate the booking was successfully \"dibatalkan\" on \"Kos Bbkquweeee Gambir Jakarta Pusat\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.embedding("image/png", "embedded0.png", "Booking - Book a kost with filter 24 hours");
formatter.after({
  "status": "passed"
});
});