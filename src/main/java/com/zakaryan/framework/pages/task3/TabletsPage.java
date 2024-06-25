package com.zakaryan.framework.pages.task3;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TabletsPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(TabletsPage.class);

    @FindBy(xpath = "//h1")
    private WebElement tabletsTitle;

    @FindBy(xpath = "//span[text()='Samsung']")
    private WebElement manufacturer;

    @FindBy(xpath = "//button[@data-autotest-id='aprice']")
    private WebElement cheaperButton;

    @FindBy(xpath = "//input[@class='_3TbaT mini-suggest__input']")
    private WebElement input;

    @FindBy(xpath = "//button[@data-auto='search-button']")
    private WebElement searchButton;


    private List<WebElement> productList;
    String productTitle;
    String productPrice;


    //2
    @Step("Проверить открытие страницы 'Планшеты'")
    public TabletsPage verifyTabletsTitle(){
        waitUntilElementToBeVisible(tabletsTitle);
        Assert.assertEquals("Cтраница не открылась",
                "Планшеты", tabletsTitle.getText());
        logger.info("Открывается страница Планшеты");
        return this;
    }
    //3
    @Step("Выбрать в меню фильтров производителя: Samsung")
    public TabletsPage chooseManufacturer(){
        waitUntilElementToBeClickable(manufacturer).click();
        logger.info("Выбран фильтр производителя Samsung");
        return this;
    }
    //4
    @Step("Установить сортировку: подешевле")
    public TabletsPage clickCheaperButton(){
        waitUntilElementToBeClickable(cheaperButton).click();
        logger.info("Установлена сортировка: подешевле");
        return this;
    }
    @Step("Вывести в лог первые 5 найденных товаров (название и цену)")
    public TabletsPage logProducts(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productList = driverManager.getDriver().findElements(By.xpath("//div[@data-auto-themename='listDetailed']"));
        for (int i = 0; i < 5 && i < productList.size(); i++) {
            WebElement product = productList.get(i);
            moveToElement(product);
            String title = product.findElement(By.xpath(".//h3")).getText();
            String price = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText();
            if (i == 1){
                productTitle = title;
                productPrice = price;
            }
            logger.info("Название: " + title + ". Цена: " + price);
        }
        return this;
    }
    //7
    @Step("Поиск и сравнение искомого продукта")
    public TabletsPage searchSecondItem(){
        input.sendKeys(productTitle);
        searchButton.click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        productList = driverManager.getDriver().findElements(By.xpath("//div[@data-auto-themename='listDetailed']"));
        WebElement product = productList.get(0);
        String title = product.findElement(By.xpath(".//h3")).getText();
        String price = product.findElement(By.xpath(".//span[@data-auto='snippet-price-current']/span[1]")).getText();
        Assert.assertEquals("Названия не совпадают", productTitle, title);
        Assert.assertEquals("Цены не совпадают", productPrice, price);
        return this;
    }
}
