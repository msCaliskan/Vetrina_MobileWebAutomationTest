Feature: Mobile | Search User searchs for a product

  @smoke
  Scenario: User searchs for a product

    And The user visits Vetrina homepage
    And The user verifies redirected to homepage
    And The user fills "Terlik" in the searchbox and click
    And The user verifies redirected to "/tum-urunler?searchValue=Terlik" page
    Then The user should see all search results match with "Terlik"
