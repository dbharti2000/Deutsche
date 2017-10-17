package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.SearchFor;
import com.db.am.bauhaus.project.SearchTarget;
import com.db.am.bauhaus.project.SessionVar;
import com.db.am.bauhaus.project.pages.MainSearchPage;
import com.db.am.bauhaus.project.steplib.SearchUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

/**
 * Created by ongshir on 05/10/2016.
 */
public class SearchSteps {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Steps
    SearchUser user;

    MainSearchPage mainSearchPage;
    Actor theUser = Actor.named("theUser");



    @Given("^John is viewing the Etsy landing page$")
    public void goto_landing_page() {
        mainSearchPage.open();
        user.assertLandingPageTitle();
    }

    @Given("^user is at Etsy homepage$")
    public void goto_homepage() {
        goto_landing_page();
    }

    @Given("^([^\\s]+) is viewing the Etsy landing page \\(screenplay\\)$")
    public void goto_landing_page_screenplay(String theUser) {
        theActorCalled(theUser).attemptsTo(Open.browserOn().the(mainSearchPage));
    }

    @When("^he searches for a product ([^\\s]+) from the input box$")
    public void search_from_input_box(String searchKeyword) {
        user.search_from_input_box(searchKeyword);
    }

    @When("^he selects the first menu item$")
    public void select_first_menu_item() {
        user.select_menu_item();
    }

    @When("^he selects the Home & Living icon$")
    public void select_home_and_living_icon() throws InterruptedException {
        user.select_home_living_icon();
    }

    @When("^he selects the first link from the drop down menu$")
    public void select_from_drop_down_menu() {
        user.select_from_drop_down();
    }

    @When("^he searches for a product from the input box \\(screenplay\\)$")
    public void search_from_input_box_screenplay() {
        theActorInTheSpotlight().attemptsTo(SearchFor.randomText());
    }

    @Then("^the result should contain (.*)$")
    public void result_should_contain_menu_item(String expectedKeyword) {
        user.verify_search_keyword_in_result_page(expectedKeyword);
    }

    @Then("^Then he can see category (.*)$")
    public void homepage_should_contain_categories(String category) {
        user.verify_categories_on_homepage(category);
    }

    @Then("^the result should have link text")
    public void result_should_contain_link_text() {
        user.verify_link_text_in_result_page();
    }

    @Then("^the result should be displayed \\(screenplay\\)$")
    public void verify_search_result_screenplay() {
        String searchText = Serenity.sessionVariableCalled(SessionVar.SEARCH_TEXT).toString();
        theActorInTheSpotlight().should(
                seeThat("the top categories header ", the(SearchTarget.TOP_CATEGORIES_HEADER), containsText(searchText)),
                seeThat("the all categories header ", the(SearchTarget.ALL_CATEGORIES_HEADER), containsText(searchText))
        );
    }

}

