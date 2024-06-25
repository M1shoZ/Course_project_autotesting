package com.zakaryan.framework.pages.task1;

import com.zakaryan.framework.managers.DriverManager;
import com.zakaryan.framework.managers.PageManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(1000));
    protected PageManager pageManager = PageManager.getInstance();

    public BasePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }
}