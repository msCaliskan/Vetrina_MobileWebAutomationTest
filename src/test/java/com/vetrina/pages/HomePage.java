package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.ConfigurationReader;
import com.vetrina.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{

    @FindBy(xpath = "//*[text()='Kabul Ediyorum']") public WebElement cookies_Loc;

    @FindBy(xpath = "(//*[@class='MuiBox-root css-k008qs'])[2]") public WebElement loginBtn_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(xpath = "(//*[@class='MuiBox-root css-k008qs'])[1]") public WebElement hamburgerMenuBtn_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;

    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickablility(cookies_Loc,5);
        cookies_Loc.click();
        BrowserUtils.waitFor(2);
    }

    public static void checkHomePage(){
        String expectedTitle ="Vetrina";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void clickLogin(){
        BrowserUtils.waitForClickablility(loginBtn_Loc,5);
        loginBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void searchBox(String string){
        searchBox_Loc.sendKeys(string+Keys.ENTER);
        BrowserUtils.waitFor(1);
    }

    public void clickHambMenuBtn(){
        BrowserUtils.waitForClickablility(hamburgerMenuBtn_Loc,5);
        new HomePage().hamburgerMenuBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }


}
