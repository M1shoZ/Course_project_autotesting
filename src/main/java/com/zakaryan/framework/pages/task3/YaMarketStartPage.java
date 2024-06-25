package com.zakaryan.framework.pages.task3;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class YaMarketStartPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(YaMarketStartPage.class);

    @FindBy(xpath = "//meta[@property='og:url']")
    private WebElement url;

    @FindBy(xpath = "//button[@class = '_3Cep- _3HNZP']")
    private WebElement forYouButton;

    @FindBy(xpath = "//button[@class = '_30-fz button-focus-ring Hkr1q _1pHod _2rdh3 _3rbM-']")
    private WebElement catalogButton;

    @FindBy(xpath = "//li[@data-zone-name='category-link']/a")
    private List<WebElement> categoryList;

    @FindBy(xpath = "//div[@role = 'heading' and @aria-level = '3']")
    private List<WebElement> subcategoryList;

    @FindBy(xpath = "//ul[@data-autotest-id]//li//a")
    private List<WebElement> subSubcategoryList;

    //1
    @Step("Проверить открытие главной страницы Яндекс.Маркета")
    public YaMarketStartPage verifyPage(){
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualUrl = url.getAttribute("content");
        Assert.assertTrue("Текущий URL не совпадает с ожидаемым",
                "https://market.yandex.ru/".equals(actualUrl));
        logger.info("Открывается главная страница Яндекс.Маркета");
        return this;
    }
    //2
    @Step("Нажать на каталог")
    public YaMarketStartPage clickOnCatalogButton(){
        waitUntilElementToBeClickable(catalogButton).click();
        logger.info("Переход в каталог");
        return this;
    }
    @Step("Навести на категорию Ноутбуки и компьютеры")
    public YaMarketStartPage moveToCategoryLaptopsComputers(){
        for (WebElement element: categoryList) {
            waitUntilElementToBeVisible(element);
            if (element.findElement(By.xpath("./span")).getText().equals("Ноутбуки и компьютеры")) {
                moveToElement(element);
                logger.info("Переход на категорию Ноутбуки и компьютеры");
            }
        }
        return this;
    }
    @Step("Навести на категорию Ноутбуки и планшеты")
    public YaMarketStartPage subcategoryList() {
        for (WebElement item : subcategoryList) {
            if (waitUntilElementToBeVisible(item).getText().equals("Ноутбуки и планшеты")) {
                moveToElement(item);
            }
        }
        logger.info("Переход на категорию Ноутбуки и планшеты");
        return this;
    }
    @Step("Нажать на пункт Планшеты")
    public TabletsPage clickOnItemOfsubSubCategory() {
        for (WebElement item : subSubcategoryList) {
            if (waitUntilElementToBeVisible(item).getText().equals("Планшеты")) {
                moveToElement(item);
                item.click();
                logger.info("Переход на страницу Планшеты");
                return pageManager.getTabletsPage();
            }
        }
        Assert.fail("Не найден пункт меню ");
        return pageManager.getTabletsPage();
    }
}
