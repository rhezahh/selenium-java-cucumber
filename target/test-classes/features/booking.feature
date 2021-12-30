Feature: Booking
  @booking
  Scenario: Booking - Book a kost with filter 24 hours
    Given user navigates to "jambu"
    And user click on Enter button
    When user login as Tenant via phone number "rheza tenant"
    And user search area with value "Jakarta"
    And user click on Mamikos Promo Ngebut pop up
    When user click filter kos with "Akses 24 Jam"
    And user turn on the booking langsung filter
    When user click on kost list
    And user dismiss ftue screen pop up
    And user click on ajukan sewa button
    When user click on terms and condition button
    And user click on ajukan sewa in booking confirmation page
    And user click chat pemilik kos
    Then user validate text messages has sent "Halo Bapak/Ibu Test Auto Activate."
    And user click on batalkan booking button
    Then user validate the booking was successfully "dibatalkan" on "Kos Bbkquweeee Gambir Jakarta Pusat"