package com.juaracoding.cucumber.drivers;

import com.juaracoding.cucumber.drivers.strategies.DriverStrategy;
import com.juaracoding.cucumber.drivers.strategies.DriverStrategyImplementer;
import com.juaracoding.cucumber.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;
    private DriverSingleton(String driver){//pilih browser
        instantiate(driver);
    }
    public WebDriver instantiate(String strategy){ //untuk memilih browser
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static DriverSingleton getInstance(String driver){
        if(instance == null){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }
}