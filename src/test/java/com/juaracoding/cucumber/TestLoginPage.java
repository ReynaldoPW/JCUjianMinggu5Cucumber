package com.juaracoding.cucumber;

import com.juaracoding.cucumber.pages.LoginPage;
import com.juaracoding.cucumber.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLoginPage {
    public static WebDriver driver;
    public static LoginPage loginPage = new LoginPage();
    public TestLoginPage(){
        driver = Hooks.driver;
    }
    @Given("User is on the login page")
    public void user_is_on_the_login_page(){
        driver.get(Constants.URL);
        loginPage.setDismissButton();
        loginPage.clickMyAccount();
        System.out.println("user is on the login page");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials(){
        loginPage.enterUsername("reypau");
        loginPage.enterPassword("formeonly123");
        System.out.println("user enters valid credentials");
    }

    @When("User enters invalid credentials")
    public void user_enters_invalid_credentials(){
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin123");
        System.out.println("user enters invalid credentials");
    }

    @When("User clicks login button")
    public void user_clicks_login_button(){
        loginPage.clickLoginButton();
        System.out.println("user clicks login button");
    }
    @When("User logout from existing account")
    public void user_logout_from_existing_account(){
        loginPage.clickLogoutBtn();
        System.out.println("User logout from existing account");
    }

    @Then("User should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page(){
        loginPage.logoHompepage();
        System.out.println("user should be redirected to the home page");
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message(){
        loginPage.errorMessage();
        System.out.println("user should see an error message");
    }
}
