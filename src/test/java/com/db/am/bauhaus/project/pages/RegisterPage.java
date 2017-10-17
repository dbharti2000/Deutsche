package com.db.am.bauhaus.project.pages;

import com.db.am.bauhaus.project.DataContainer;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;

public class RegisterPage extends PageObject{

    DataContainer dataContainer = new DataContainer();

    public String username = RandomStringUtils.random(12, true, false);
    public String  userEmail = username + "@gmail.com";
    String userPassword="test1234";

    @FindBy(id = "register")
    WebElementFacade register_button;

    @FindBy(id = "first-name")
    WebElementFacade first_name;

    @FindBy(id = "email")
    WebElementFacade email;

    @FindBy(id = "password")
    WebElementFacade password;

    @FindBy(id = "password-repeat")
    WebElementFacade confirm_password;

    @FindBy(id = "register_button")
    WebElementFacade register;

    @FindBy(css= ".confirm-email-notice p")
    WebElementFacade confirm_email_notice;

    @FindBy(css=".recaptcha-checkbox-checkmark")
    WebElementFacade captcha;

    public void register(){
        register_button.click();
        first_name.sendKeys(username);
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        confirm_password.sendKeys(userPassword);
        selectCaptcha();
        register.click();
        dataContainer.addObject("email",userEmail);
        dataContainer.addObject("password",userPassword);
        System.out.println("email is "+(String)dataContainer.getObject("email"));
        System.out.println("password is "+(String)dataContainer.getObject("password"));

    }

    public void selectCaptcha(){
        if(captcha.isPresent() == true){
            captcha.click();
        }
    }

    public DataContainer getDataContainer(){
        return  dataContainer;
    }


    public String verifyConfirmEmailText() {
        return confirm_email_notice.getText().toLowerCase();

    }








}
