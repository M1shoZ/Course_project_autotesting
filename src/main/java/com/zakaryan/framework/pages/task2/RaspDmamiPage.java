package com.zakaryan.framework.pages.task2;

import com.zakaryan.framework.pages.task1.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RaspDmamiPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//input[@placeholder='группа ...']")
    private WebElement input;

    @FindBy(xpath = "//div[@id='221-361']")
    private WebElement groupButton;

    @FindBy(xpath = "//div[@class='schedule-day schedule-day_today']")
    private WebElement today;

    //4
    @Step("Ввести номер группы (221-361)")
    public RaspDmamiPage fillGroupNumber(){
        input.sendKeys("221-361");
        logger.info("Введён номер группы");
        return this;
    }
    //5
    @Step("Окрыть расписание группы и проверить совпадает ли день недели")
    public RaspDmamiPage clickGroupButton(){
        groupButton.click();
        today = today.findElement(By.xpath(".//div"));
        String lowToday = today.getText().toLowerCase();
        Assert.assertTrue("День недели не совпадает", lowToday.contains(new SimpleDateFormat("EEEE").format(new Date())));
        logger.info("Открыто расписание группы, дни недели совпадают");
        return this;
    }

}
