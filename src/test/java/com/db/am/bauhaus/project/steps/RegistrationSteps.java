package com.db.am.bauhaus.project.steps;

import com.db.am.bauhaus.project.steplib.RegistrationUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class RegistrationSteps {

    @Steps
    RegistrationUser user;


    @When("^user submits the registration form$")
    public void registerUser() {
        user.register();

    }

    @Then("^user should get registration confirmation message$")
    public void checkUserRegistered() {
        user.verify_registration_complete();
    }
}