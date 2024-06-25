package com.zakaryan.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessmatenokStartPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(ChessmatenokStartPage.class);

    @FindBy(xpath = "//p[text()='Привет! Меня зовут Жорик и я очень люблю играть в шахматы!']")
    private WebElement mainPageText;

    @FindBy(xpath = "//a[@href='https://chessmatenok.ru/rejting-fide-shahmatistov/']")
    private WebElement ratingButton;

    @FindBy(xpath = "//ul[@id='menu-razdely-sajta' and not(@style='display: none;')]/li/a[@href='https://chessmatenok.ru/category/debyuty-i-gambity/']")
    private WebElement gambitsButton;

    @FindBy(xpath = "//input[@class='search-form__text']")
    private WebElement input;

    @FindBy(xpath = "//button[@class='search-form__submit']")
    private WebElement searchButton;



    @Step("Проверить открытие главной страницы ")
    public ChessmatenokStartPage verifyPage(){
        Assert.assertEquals("Главная страница не открылась",
                "Привет! Меня зовут Жорик и я очень люблю играть в шахматы!", mainPageText.getText());
        logger.info("Открывается главная страница");
        return this;
    }

    @Step("Нажать на кнопку 'Рейтинг ФИДЕ шахматистов'")
    public RaitingPage clickOnRatingButton(){
        ratingButton.click();
        logger.info("Открылась страница рейтинга");
        return pageManager.getRaitingPage();
    }

    @Step("Нажать на кнопку 'Дебюты и гамбиты'")
    public DebutsPage clickOnGambitsButton(){
        gambitsButton.click();
        logger.info("Открылась страница дебютов");
        return pageManager.getDebutsPage();
    }

    @Step("Ввод в поле поиска")
    public SearchResultPage fillInput(){
        input.sendKeys("Каро-Канн");
        searchButton.click();
        logger.info("Открылась страница со статьями");
        return pageManager.getSearchResultPage();
    }
}
