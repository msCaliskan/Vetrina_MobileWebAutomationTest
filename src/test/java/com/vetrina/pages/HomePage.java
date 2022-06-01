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

    @FindBy(css = "#password") public WebElement password_Loc;

    @FindBy(xpath = "(//*[@class='MuiBox-root css-k008qs'])[1]") public WebElement hamburgerMenuBtn_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;

    @FindBy(xpath = "//*[@class='MuiSvgIcon-root jss125']") public WebElement findBtn_Loc;

    public void gotoHomePage(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickablility(cookies_Loc,5);
        cookies_Loc.click();
        BrowserUtils.waitFor(2);
    }

    public void mobilLogin(){
        String email = ConfigurationReader.get("user_email");
        String password = ConfigurationReader.get("user_password");

        email_Loc.sendKeys(email);
        password_Loc.sendKeys(password);
    }

    public static void checkHomePage(){
        String expectedUrl ="https://www.jeanslab.com/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
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

    public void invalidEmailMobile(){
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        password_Loc.sendKeys(ConfigurationReader.get("user_password"));
    }
    public void invalidPasswordMobile(){
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        password_Loc.sendKeys("Inveon34...");
    }


}
