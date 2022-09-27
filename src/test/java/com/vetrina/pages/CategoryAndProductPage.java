package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-3 MuiGrid-grid-md-3')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root has-stock')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//button[contains(@aria-label,'add-to-favorites')]") public WebElement hearthBtn_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root jss140 MuiTypography-body1']") public List<WebElement> productName_Loc;

    @FindBy(xpath = "(//*[text()='Uyarı']/..//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1x0t2pd'])[2]") public WebElement uyari_Loc;

    @FindBy(xpath = "//*[@name='price']") public WebElement priceHolder_Loc;

    @FindBy(xpath = "//*[text()='Fiyatı Düşünce Haber Ver']") public WebElement fiyatDHVBtn_Loc;

    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size());

        BrowserUtils.waitFor(1);
        BrowserUtils.hover(prodList_Loc.get(a));
        BrowserUtils.waitFor(1);
        prodList_Loc.get(a).click();
        BrowserUtils.waitFor(2);

    }

    public void clickFiyatButton(){
        BrowserUtils.waitForClickablility(fiyatDHVBtn_Loc,5);
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(fiyatDHVBtn_Loc);
        BrowserUtils.waitFor(2);
    }

    public void searchResult(String string){

        List<String> allNames = new ArrayList<>();
        for (WebElement element : prodList_Loc) {
        allNames.add(element.getText());
        }
        for (int i = 0; i < productName_Loc.size(); i++) {
             allNames.get(i).contains(string);
        }
    }

    public static void navigateMobile(String tab){
        String tabLocator = "//span[text()='"+tab+"']";

        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(tabLocator)), 5);
        Driver.get().findElement(By.xpath(tabLocator)).click();
    }
    public void closePopUps(){
        BrowserUtils.waitForClickablility(uyari_Loc,5);
        uyari_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        Random rn = new Random();
        int a = rn.nextInt(sizeList_Loc.size());

        BrowserUtils.clickWithJS(sizeList_Loc.get(a));
    }

    public void validPrice(){
        String price = priceHolder_Loc.getAttribute("value");

        int b = Integer.parseInt(price);
        int c= b-5;

        priceHolder_Loc.sendKeys(Keys.CONTROL+"a");
        priceHolder_Loc.sendKeys(Keys.DELETE);
        BrowserUtils.waitFor(1);
        priceHolder_Loc.sendKeys(Integer.toString(c));
        BrowserUtils.waitFor(2);

    }
}