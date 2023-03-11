package com.juaracoding.cucumber.pages;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "button[name='login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='custom-logo-link']//img[@alt='ToolsQA Demo Site']")
    WebElement logoHomepage;
    @FindBy(xpath = "//strong[normalize-space()='ERROR']")
    WebElement errorMessage;

    @FindBy(xpath = "/html/body/p/a")
    WebElement dismissButton;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
    WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logoutBtn;
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public boolean logoHompepage(){
        return logoHomepage.isDisplayed();
    }
    public boolean errorMessage(){
        return errorMessage.isDisplayed();
    }
    public void setDismissButton(){
        dismissButton.click();
    }
    public void clickMyAccount(){
        myAccount.click();
    }
    public void clickLogoutBtn(){
        logoutBtn.click();
    }
}
