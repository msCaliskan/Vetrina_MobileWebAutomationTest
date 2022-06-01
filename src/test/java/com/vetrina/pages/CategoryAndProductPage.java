package com.vetrina.pages;

import com.vetrina.utilities.BrowserUtils;
import com.vetrina.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-3 MuiGrid-grid-md-3')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButtonBase-root has-stock')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//button[contains(@aria-label,'add-to-favorites')]") public WebElement hearthBtn_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root jss140 MuiTypography-body1']") public List<WebElement> productName_Loc;

    @FindBy(xpath = "//*[@fill='#353535']") public WebElement uyari_Loc;


    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size());



        BrowserUtils.waitFor(1);
        BrowserUtils.hover(prodList_Loc.get(a));
        BrowserUtils.waitFor(1);
        prodList_Loc.get(a).click();
        BrowserUtils.waitFor(1);
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
        uyari_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        Random rn = new Random();
        int a = rn.nextInt(sizeList_Loc.size());


        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(sizeList_Loc.get(a));
        BrowserUtils.waitFor(1);
    }

}