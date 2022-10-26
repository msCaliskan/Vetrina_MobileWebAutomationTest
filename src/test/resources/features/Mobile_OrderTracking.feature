Feature: Mobile | Order Tracking feature

  @smoke
  Scenario: Order tracking with informations

    Given The user visits Vetrina homepage
    And The user verifies redirected to homepage
    And The user clicks "Sipariş Takibi" button
    And The user enters informations
    And The user clicks "Sorgula" button
    And The user verifies "Sipariş kaydı bulunamadı." message