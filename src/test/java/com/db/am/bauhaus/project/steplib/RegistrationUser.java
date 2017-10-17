package com.db.am.bauhaus.project.steplib;

import com.db.am.bauhaus.project.pages.RegisterPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class RegistrationUser extends ScenarioSteps {

    RegisterPage registerPage;

    @Step
    public void register() {
        registerPage.register();

    }

    @Step
    public void verify_registration_complete() {
        assertThat(registerPage.verifyConfirmEmailText(), containsString("confirm"));
    }
}
