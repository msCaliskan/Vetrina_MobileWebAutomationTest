package com.vetrina.pages;

import com.vetrina.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#password") public WebElement password_Loc;

    public void mobilLogin(){
        String email = ConfigurationReader.get("user_email");
        String password = ConfigurationReader.get("user_password");

        email_Loc.sendKeys(email);
        password_Loc.sendKeys(password);
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
