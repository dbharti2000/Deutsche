package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.RestClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class HomepageApiSteps {

    private String URL = "https://www.etsy.com";
    private Response response;

    private RestClient restClient;


    @Given("^John is a Etsy customer$")
    public void i_navigate_to_Homepage() {
        //Do Nothing
    }

    @When("^he makes a GET request to landing page$")
    public void i_send_the_GET_Request()  {
        restClient.performGetRequest();
    }

    @Then("^he should get response code (\\d+)$")
    public void i_expect_the_response_code(int code) {
        restClient.assertStatusCode(code);
    }

}
