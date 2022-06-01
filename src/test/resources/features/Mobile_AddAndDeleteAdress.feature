Feature: Mobile | Add new address and delete

  @smoke
  Scenario: Add new address and delete

    Given The user visits JeansLab homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials for mobile
    And The user clicks "Giriş Yap" buttonn
    Then The user clicks login button
    And The user clicks arrow button
    And The user clicks "Adreslerim" button
    And The user verifies redirected to "/account/addresses" page
    And The user verifies "Kayıtlı adresiniz bulunmamaktadır." message
    When The user clicks "Yeni Adres Ekle" button
    And The user enters valid informations
    And The user clicks "Kaydet" button
    And The user clicks "Sil" button
    And The user verifies "Kayıtlı adresiniz bulunmamaktadır." message
    Then The user clicks arrow button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to homepage
