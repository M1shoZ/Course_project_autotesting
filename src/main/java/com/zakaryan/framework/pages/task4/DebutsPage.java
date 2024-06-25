package com.zakaryan.framework.pages.task4;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;


public class DebutsPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(DebutsPage.class);

    @FindBy(xpath = "//h1")
    private WebElement debutTitle;

    @FindBy(xpath = "//a[@href='https://chessmatenok.ru/londonskaya-sistema/']")
    private WebElement londonSystemButton;

    @FindBy(xpath = "//h1")
    private WebElement londonSystemTitle;

    private Set<String> tabs;


    @Step("Проверить переход на страницу дебютов")
    public DebutsPage verifyDebutPage(){
        Assert.assertEquals("Главная страница не открылась",
                "Дебюты и гамбиты", debutTitle.getText());
        logger.info("Открыта страница дебютов");
        return this;
    }

    @Step("Нажать на Лондонская система")
    public DebutsPage clickOnLondonSystemButton(){
       waitUntilElementToBeClickable(londonSystemButton).click();
        tabs = driverManager.getDriver().getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        String debWin = "";
        while (iterator.hasNext()){
            debWin = iterator.next();
        }
        driverManager.getDriver().switchTo().window(debWin);
        Assert.assertEquals("Страничка не загрузилась", "Лондонская система: универсальный дебютный репертуар", londonSystemTitle.getText());
        logger.info("Открывается страница дебюта");
        return this;
    }

}
