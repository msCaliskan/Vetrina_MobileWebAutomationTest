Feature: Mobile | Footer links are addressed correctly or not?

  @smoke
  Scenario Outline: Footer links validation

    Given The user visits Vetrina homepage
    And The user verifies redirected to homepage
    And The user clicks "<Links>" and verifies "<Title>"

    Examples:
      | Links                                                  | Title                                                  |
#      | Hakkımızda                                             | Hakkımızda                                             |
      | Mağazalarımız                                          | Mağazalarımız                                          |
      | İletişim                                               | İletişim                                               |
      | Gizlilik Politikası                                    | Gizlilik ve Güvenlik Bildirimi                         |
      | Sıkça Sorulan Sorular                                  | Sıkça Sorulan Sorular                                  |
      | İade İşlemleri                                         | İade İşlemleri                                         |
      | Üyelik İşlemleri                                       | Üye Ol                                                 |
      | Sipariş Takibi                                         | Sipariş Takibi                                         |
      | KVKK Aydınlatma Metni                                  | KVKK Aydınlatma Metni                                  |
      | Üyelik Sözleşmesi                                      | Üyelik Sözleşmesi                                      |
      | Mesafeli Satış Sözleşmesi                              | Mesafeli Satış Sözleşmesi                              |
      | Çerez Politikası                                       | Çerez Politikası                                       |