Feature: Mobile | Filter feature

  @smoke
  Scenario: Filtering with selected options

    Given The user visits Vetrina homepage
    And The user verifies redirected to homepage
    And The user clicks hamburger menu button
    And The user navigates to "Kadın" "Bot" category
    When The user verifies redirected to "/kadin-ayakkabi-bot" page
    And The user clicks "Filtrele" button
    And The user clicks "CASADEI" filter button
    Then The user verifies redirected to "/kadin-ayakkabi-bot?defaultMinPrice=0&pageIndex=0&defaultMaxPrice=0&lastSelectedFilter=Marka&Marka=904" page
    And The user clicks "38" filter button
    And The user verifies redirected to "/kadin-ayakkabi-bot?defaultMinPrice=0&pageIndex=0&defaultMaxPrice=0&lastSelectedFilter=size&Marka=904&size=8428" page
    And The user clicks "SİYAH" filter button
    Then The user verifies redirected to "/kadin-ayakkabi-bot?defaultMinPrice=0&pageIndex=0&defaultMaxPrice=0&lastSelectedFilter=color&Marka=904&color=8729&size=8428" page
    And The user clicks "38" button
    And The user clicks "SİYAH" button
    Then The user verifies redirected to "/kadin-ayakkabi-bot?Marka=904&color=&defaultMaxPrice=0&defaultMinPrice=0&lastSelectedFilter=color&size=" page