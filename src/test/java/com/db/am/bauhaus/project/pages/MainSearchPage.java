package com.db.am.bauhaus.project.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;

/**
 * Created by ongshir on 05/10/2016.
 */
@DefaultUrl("/")
public class MainSearchPage extends PageObject {

    public static String linkText = "";


    @FindBy(id = "search-query")
    WebElementFacade inputBox;

    @FindBy(css = ".gnav-search-inner button[type='submit']")
    WebElementFacade searchButton;

    @FindBy(css = ".top-nav-item:nth-child(1) .text-gray-darker")
    WebElementFacade searchDropDownJewelleryAndAccessories;

    @FindBy(css = "#cnav-header-inner #catnav-menubar li a")
    WebElementFacade searchDropDownClothingAndAccessories;

    @FindBy(css = ".pb-xs-3 ul:nth-child(1) li:nth-child(1) a:nth-child(1)")
    WebElementFacade searchDropDownHatsAndCaps;

    @FindBy(css = ".catnav-subcategories .catnav-tertiary ul:nth-child(1) li:nth-child(1) a:nth-child(1)")
    WebElementFacade searchDropDownBeltsAndBraces;

    @FindBy(css = "#content .vesta-hp-category-default .block-grid-xs-1 a:nth-child(1)")
    WebElementFacade jwelleryIcon;


    public MainSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchFromInputBox(String searchText) {
        inputBox.waitUntilPresent().sendKeys(searchText);
        searchButton.click();
    }

    public void selectFirstElement() {
        if (searchDropDownJewelleryAndAccessories.isPresent() == true) {
            linkText = "Hats & Caps";
            searchDropDownJewelleryAndAccessories.click();
        } else {
            linkText = "Belts & Braces";
            searchDropDownClothingAndAccessories.waitUntilPresent().click();
        }
    }

    public void selectHomeLivingIcon() throws InterruptedException {
        jwelleryIcon.click();
    }

    public void selectFirstLinkFromDropDown() {
        if(linkText.equalsIgnoreCase("Hats & Caps")){
            searchDropDownHatsAndCaps.waitUntilPresent().click();
        } else {
            searchDropDownBeltsAndBraces.waitUntilPresent().click();
        }
    }


    public String getTopCategoriesHeader() {
        return find(By.cssSelector("div.ui-toolkit.cat-nav")).getText().toLowerCase();
    }

    public String getAllCategoriesHeader() {
        return find(By.cssSelector("h1.display-inline.text-smaller")).getText();
    }

    public String getResultHeader() {
        return find(By.cssSelector(".float-left h1")).getText();
    }

}
