package com.zakaryan.framework.pages.task2;

import com.zakaryan.framework.pages.task1.StartPage;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

public class SchedulePage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//a[@href='https://rasp.dmami.ru/session']")
    private WebElement lookOnTheWebsiteButton;

    @FindBy(xpath = "//h4")
    private WebElement rasp;

    private Set<String> tabs;

    //3
    @Step("Нажать на 'Смотреть на сайте'")
    public RaspDmamiPage clickLookOnTheWebsiteButton(){
        lookOnTheWebsiteButton.click();
        tabs = driverManager.getDriver().getWindowHandles();
        Iterator<String> iterator = tabs.iterator();
        String raspWin = "";
        while (iterator.hasNext()){
            raspWin = iterator.next();
        }
        driverManager.getDriver().switchTo().window(raspWin);
        Assert.assertEquals("Страничка не загрузилась", "Расписание зачетов и экзаменов", rasp.getText());
        logger.info("Открыта страница с расписаниями группы");
        return pageManager.getRaspDmamiPage();
    }
}
