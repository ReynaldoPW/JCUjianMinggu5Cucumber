package com.juaracoding.cucumber;

import com.juaracoding.cucumber.pages.CheckoutPage;
import com.juaracoding.cucumber.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCheckoutPage {
    public static WebDriver driver;
    public static CheckoutPage checkoutPage = new CheckoutPage();
    public TestCheckoutPage(){
        driver = Hooks.driver;
    }
    @When("user searches for a product")
    public void user_searches_for_a_product(){
        checkoutPage.searchProduct("product");
        System.out.println("user searches for a product");
    }
    @And("user adds the product to the cart")
    public void user_adds_the_product_to_the_cart(){
        checkoutPage.addToCart();
        System.out.println("user adds the product to the cart");
    }
    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout(){
        checkoutPage.checkout();
        Hooks.delay(Constants.DETIK);
        System.out.println("user proceeds to checkout");
    }
    @And("user fills in the checkout form")
    public void user_fills_in_the_checkout_form(){
        Hooks.delay(Constants.DETIK);
        checkoutPage.fillsCredentialAndAddress("Rey","pau","","12345","jl kemana aja","Jakarta","10101");
        checkoutPage.consentTerms();
        System.out.println("user fills in the checkout form");
    }
    @And("user clicks place order button")
    public void user_clicks_place_order_button(){
        checkoutPage.clickPlaceOrderButton();
        System.out.println("user clicks place order button");
    }
    @Then("user should see a confirmation message")
    public void user_should_see_a_confirmation_message(){
        checkoutPage.getConfirmationMessage();
        Assert.assertEquals(checkoutPage.getConfirmationMessage(),"Thank you. Your order has been received.");
        System.out.println("user should see a confirmation message");
    }

}
