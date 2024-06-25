package com.zakaryan.framework.pages.task2;

import com.zakaryan.framework.pages.task1.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MospolytechStartPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//a[@class='user-nav__item-link' and @title='Расписание']")
    private WebElement scheduleButton;

    @FindBy(xpath = "//h1")
    private WebElement scheduleTitle;


    //1
    @Step("Проверить загружена ли страница")
    public MospolytechStartPage verifyTitle(){
        Assert.assertTrue("Страничка не загрузилась", title.isDisplayed());
        logger.info("Страничка открыта");
        return this;
    }
    //2
    @Step("Нажать на кнопку расписания")
    public SchedulePage clickScheduleButton(){
        scheduleButton.click();
        Assert.assertEquals("Страничка не загрузилась", "Расписания", scheduleTitle.getText());
        logger.info("Страничка расписания открыта");
        return pageManager.getSchedulePage();
    }
}
