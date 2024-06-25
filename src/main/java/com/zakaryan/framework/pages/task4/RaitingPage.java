package com.zakaryan.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

public class RaitingPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(RaitingPage.class);

    @FindBy(xpath = "//div[@class='fide-title']")
    private WebElement ratingTitle;

    @FindBy(xpath = "//a[@href='http://ratings.fide.com/card.phtml?event=1503014']")
    private WebElement firstPlayerButton;

    @FindBy(xpath = "//div[@class='section-profile__title']")
    private WebElement profileTitle;


    private Set<String> tabs;


    @Step("Проверить открытие страницы рейтинга")
    public RaitingPage verifyPage(){
        Assert.assertEquals("Главная страница не открылась",
                "Рейтинг лист ФИДЕ, ТОП 100 по классике, рапиду и блицу", ratingTitle.getText());
        logger.info("Открывается страница рейтинга");
        return this;
    }
    @Step("Нажать на первого шахматиста")
    public FidePage clickPlayerButton(){
        waitUntilElementToBeClickable(firstPlayerButton).click();
        tabs = driverManager.getDriver().getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        String fideWin = "";
        while (iterator.hasNext()){
            fideWin = iterator.next();
        }
        driverManager.getDriver().switchTo().window(fideWin);
        Assert.assertEquals("Страничка не загрузилась", "PROFILE INFO", profileTitle.getText());
        logger.info("Переход на страницу профиля шахматиста");
        return pageManager.getFidePage();
    }
}
