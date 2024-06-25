package com.zakaryan.framework.pages.task1;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StartPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(StartPage.class);

    @FindBy(xpath = "//h2")
    private WebElement title;

    @FindBy(xpath = "//span[@class='ng-binding']")
    private WebElement remainingItems;

    @FindBy(xpath = "//li/span")
    private List<WebElement> items;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> itemsCheckboses;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement input;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement inputButton;

    private int totalElements = 5;
    private int remaining = 5;
    private String expectedText = remaining + " of " + totalElements + " remaining";
    private int i = 0;

    //1
    @Step("Проверить, что на странице присутствует заголовек - 'LambdaTest Sample App'")
    public StartPage verifyTitle(){
        Assert.assertTrue("Страничка не загрузилась", title.isDisplayed());
        Assert.assertEquals("Текст заголовка не совпал", "LambdaTest Sample App", title.getText());
        logger.info("Заголовок страницы - 'LambdaTest Sample App'.");
        return this;
    }
    //2
    @Step("Проверить, что присутствует текст '5 of 5 remaining'")
    public StartPage verifyRemainingItemsText(){
        Assert.assertEquals("Текст не появился", expectedText, remainingItems.getText());
        logger.info("Присутствует текст '5 of 5 remaining'.");
        return this;
    }

    //3
    @Step("Проверить, что первый элемент не зачеркнут")
    public StartPage verifyFirstElementNotChecked(){
        Assert.assertTrue(i + " элемент зачёркнут", items.get(i).getAttribute("class").contains("done-false"));
        logger.info("Первый элемент зачеркнут.");
        return this;
    }
    //4
    @Step("Отметить первый элемент")
    public StartPage clickOnFirstItem(){
        itemsCheckboses.get(i).click();
        remaining--;
        expectedText = remaining + " of " + totalElements + " remaining";
        Assert.assertTrue(i + " элемент НЕ зачёркнут", items.get(i).getAttribute("class").contains("done-true"));
        logger.info("Первый элемент отмечен.");
        Assert.assertEquals("Не уменьшилось на один", expectedText, remainingItems.getText());
        logger.info("Число оставшихся элементов уменьшилось на один.");
        return this;
    }
    //5
    @Step("Проверить, что остальные элементы списка не зачеркнуты")
    public StartPage verifyRemainingElementNotChecked(){
        for (int i = 1; i < items.size(); i++) {
            Assert.assertTrue(i + " элемент зачёркнут", items.get(i).getAttribute("class").contains("done-false"));
            logger.info("Элемент " + i + " зачеркнут.");
        }
        return this;
    }
    @Step("Отметить остальные элементы")
    public StartPage clickOnRemainingItems(){
        for (int i = 1; i < items.size(); i++) {
            itemsCheckboses.get(i).click();
            remaining--;
            expectedText = remaining + " of " + totalElements + " remaining";
            Assert.assertTrue(i + " элемент НЕ зачёркнут", items.get(i).getAttribute("class").contains("done-true"));
            logger.info("Элемент " + i + " зачеркнут.");
            Assert.assertEquals("Не уменьшилось на один", expectedText, remainingItems.getText());
            logger.info("Число оставшихся элементов уменьшилось на один.");
        }
        return this;
    }
    //6
    @Step("Добавить новый элемент списка")
    public StartPage addNewItem(){
        input.sendKeys("test item");
        inputButton.click();
        remaining++;
        totalElements++;
        expectedText = remaining + " of " + totalElements + " remaining";
        Assert.assertTrue(totalElements + " элемент зачёркнут", items.get(5).getAttribute("class").contains("done-false"));
        Assert.assertEquals("Не увеличилось на один", expectedText, remainingItems.getText());
        logger.info("Добавлен новый элемент списка,новый элемент списка не зачеркнут,отображаемое общее число и число оставшихся элементов увеличиваются на 1");
        return this;
    }
//    7
    @Step("Нажать на новый элемент списка")
    public StartPage clickOnNewItem(){
        itemsCheckboses = driverManager.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
        itemsCheckboses.get(5).click();
        remaining--;
        expectedText = remaining + " of " + totalElements + " remaining";
        Assert.assertTrue(totalElements + " элемент НЕ зачёркнут", items.get(5).getAttribute("class").contains("done-true"));
        Assert.assertEquals("Не уменьшилось на одну", expectedText, remainingItems.getText());
        logger.info("Нажат на новый элемент списка, он стал зачеркнутым, количество оставшихся элементов уменьшилось на 1");
        return this;
    }
}
