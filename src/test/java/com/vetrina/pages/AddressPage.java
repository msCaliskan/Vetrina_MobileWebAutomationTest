package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#countryId") public WebElement ulke_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiMenuItem-root MuiMenuItem-gutters')]") public List<WebElement> dataList_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiMenuItem-root MuiMenuItem-gutters')]") public WebElement country_Loc;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#identifier") public WebElement tcKimlik_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;

    public void enterAdress(){
        BrowserUtils.scrollDown();
        BrowserUtils.waitFor(1);

        adresBasligi_Loc.sendKeys(ConfigurationReader.get("adress_title"));
        ad_Loc.sendKeys(ConfigurationReader.get("user_firstName"));
        soyad_Loc.sendKeys(ConfigurationReader.get("user_lastName"));
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys(ConfigurationReader.get("user_phone1"));
        postaKodu_Loc.click();
        postaKodu_Loc.sendKeys("34340");
        tcKimlik_Loc.click();
        tcKimlik_Loc.sendKeys(ConfigurationReader.get("user_identifier"));
        BrowserUtils.waitFor(1);

        ulke_Loc.click();
        BrowserUtils.waitFor(1);
        country_Loc.click();

        sehir_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allCity = dataList_Loc;

        for (int i = 1; i <= allCity.size(); i++) {
            if (allCity.get(i).getText().contains("Ankara")){
                allCity.get(i).click();
                break;
            }
        }

        BrowserUtils.waitFor(1);

        ilce_Loc.click();
        BrowserUtils.waitFor(1);

        List<WebElement> allCounty= dataList_Loc;

        for (int i = 1; i <= allCounty.size(); i++) {
            if (allCounty.get(i).getText().contains("EVREN")){
                allCounty.get(i).click();
                break;
            }
        }


        BrowserUtils.waitFor(1);
        adres_Loc.sendKeys("test test test");
    }
}
