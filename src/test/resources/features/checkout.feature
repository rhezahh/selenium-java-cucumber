@checkout
Feature: Checkout
 @checkout-success
  Scenario: Checkout - Successfully Checkout Pillow
    Given user navigates to "midtrans"
    And user click "BUY NOW" button
    When user click on checkout button
    And user should verify ordered item "Midtrans Pillow" and amount "20,000"
    And user choose "Credit/Debit Card" as a payment method
    When user input credit card number "4811111111111114", expiry date "0225" and cvv number "123"
    Then user verify pay now button is appeared