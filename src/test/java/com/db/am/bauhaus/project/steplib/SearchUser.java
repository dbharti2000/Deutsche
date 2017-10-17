package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.DataContainer;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchUser extends ScenarioSteps {

    MainSearchPage mainSearchPage;


    String searchText = "craft";
    String linkTextBelts = "Belts & Braces";
    String linkTextHats = "Hats & Caps";

    public static final String LANDING_PAGE_TITLE = "Etsy.com | Shop for anything from creative people everywhere";

    @Step
    public void search_from_input_box(String searchKeyword) {
        mainSearchPage.searchFromInputBox(searchKeyword);
    }

    @Step
    public void select_menu_item() {
        mainSearchPage.selectFirstElement();
    }

    @Step
    public void select_home_living_icon() throws InterruptedException {
        mainSearchPage.selectHomeLivingIcon();
    }

    @Step
    public void select_from_drop_down() {
        mainSearchPage.selectFirstLinkFromDropDown();
    }

    @Step
    public void verify_result_for_top_categories() {
        assertThat(mainSearchPage.getTopCategoriesHeader(), containsString(searchText.toLowerCase()));
    }

    @Step
    public void verify_result_for_all_categories() {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(searchText));
    }

    @Step
    public void assertLandingPageTitle() {
        assertThat(mainSearchPage.getTitle(), containsString(LANDING_PAGE_TITLE));
    }

    @Step
    public void verify_search_keyword_in_result_page(String searchText) {
        assertThat(mainSearchPage.getResultHeader(), containsString(searchText));
    }


    @Step
    public void verify_categories_on_homepage(String category) {
        assertThat(mainSearchPage.getAllCategoriesHeader(), containsString(category));
    }

    @Step
    public void verify_link_text_in_result_page() {

        if (MainSearchPage.linkText.equalsIgnoreCase("Hats & Caps")) {
            assertThat(mainSearchPage.getResultHeader(), containsString(linkTextHats));

        } else {
            assertThat(mainSearchPage.getResultHeader(), containsString(linkTextBelts));
        }
    }


}


