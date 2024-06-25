package com.zakaryan.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FidePage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(FidePage.class);

    @FindBy(xpath = "//div[@class='col-lg-8 profile-top-title']")
    private WebElement playerName;

    @Step("Проверить имя шахматиста")
    public FidePage verifyName(){
        Assert.assertEquals("Имя не совпало","Carlsen, Magnus", playerName.getText());
        logger.info("Переход на информацию о ценах");
        return this;
    }

}
