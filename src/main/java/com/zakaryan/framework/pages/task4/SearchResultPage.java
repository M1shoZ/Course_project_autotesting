package com.zakaryan.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SearchResultPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//h1[@class='page-title mb30']")
    private WebElement searchTitle;

    @FindBy(xpath = "//div[@class='site-content']//span[@itemprop='headline']")
    private List<WebElement> resultsList;


    @Step("Проверить открытие страницы поиска")
    public SearchResultPage verifySearchResultPage(){
        Assert.assertTrue("Главная страница не открылась", searchTitle.getText().contains("Поиск по запросу:"));
        logger.info("Страница поиска открыта");
        return this;
    }

    @Step("Проверить открытие страницы рейтинга")
    public SearchResultPage checkResultsText(){
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue("Отсутствует искомая фраза", resultsList.get(i).getText().contains("Каро-Канн"));
            logger.info("В статье №" + (i+1) + " есть искомая фраза");
        }
        return this;
    }

}
