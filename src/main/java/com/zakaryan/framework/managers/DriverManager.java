package com.zakaryan.framework.managers;

import com.zakaryan.framework.utils.PropConst;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private WebDriver driver;
    private TestPropManager propManager = TestPropManager.getInstance();

    private static DriverManager INSTANCE = null;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }
    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
    private void initDriver() {
        System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropConst.PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



}

