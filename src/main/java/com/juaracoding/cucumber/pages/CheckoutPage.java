package com.juaracoding.cucumber.pages;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import com.juaracoding.cucumber.utils.Constants;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver driver;
    JavascriptExecutor js;
    public CheckoutPage() {
        this.driver = DriverSingleton.getDriver();
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "billing_first_name")
    WebElement firstNameField;

    @FindBy(id = "billing_last_name")
    WebElement lastNameField;

    @FindBy(id = "billing_email")
    WebElement emailField;

    @FindBy(id = "billing_phone")
    WebElement phoneField;

    @FindBy(id = "billing_country")
    WebElement countryField;

    @FindBy(id = "billing_address_1")
    WebElement addressField;

    @FindBy(id = "billing_city")
    WebElement cityField;

    @FindBy(id = "billing_state")
    WebElement stateField;

    @FindBy(id = "billing_postcode")
    WebElement postcodeField;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;
    @FindBy(xpath = "//input[@name='s']")
    WebElement searchBox;

    @FindBy(xpath = "//a[@class='noo-search']")
    WebElement btnSearch;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/h3/a")
    WebElement product;

    @FindBy(id = "pa_color")
    WebElement selectColor;

    @FindBy(id = "pa_size")
    WebElement selectSize;

    @FindBy(xpath = "//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"nav-menu-item-cart\"]/a/span/span[2]")
    WebElement cartBtn;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward wp-element-button']")
    WebElement proceedToCheckoutButton;


    @FindBy(xpath = "//p[@class='woocommerce-thankyou-order-received']")
    WebElement confirmationMessage;

    @FindBy(xpath = "//input[@id='terms']")
    WebElement consentTerms;

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }
    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }
    public void searchProduct(String searchbox){
        btnSearch.click();
        searchBox.sendKeys(searchbox, Keys.ENTER);
    }
    public void addToCart(){
        product.click();
        js.executeScript("window.scrollBy(0,400)");
        Select color = new Select(selectColor);
        color.selectByValue("pink");
        Select size = new Select(selectSize);
        size.selectByValue("37");
        addToCart.click();
    }
    public void checkout(){
        cartBtn.click();
        js.executeScript("window.scrollBy(0,500)");
        proceedToCheckoutButton.click();
    }
    public void fillsCredentialAndAddress(String firstname,String lastname,String email,String phone,String address,String city,String postcode){
        js.executeScript("window.scrollBy(0,400)");
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        Select selectCountry = new Select(countryField);
        selectCountry.selectByVisibleText("Indonesia");
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        Select selectProvince = new Select(stateField);
        selectProvince.selectByVisibleText("DKI Jakarta");
        postcodeField.sendKeys(postcode);
    }
    public void consentTerms(){
        consentTerms.click();
    }
}
