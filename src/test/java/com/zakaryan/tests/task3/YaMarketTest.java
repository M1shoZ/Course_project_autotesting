package com.zakaryan.tests.task3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class YaMarketTest extends BaseTests{

    @Test
    @DisplayName("Тестирование Яндекс Маркета (проверка поиска товара).")
    public void test(){
        pageManager.getYaMarketStartPage()
                .verifyPage()
                .clickOnCatalogButton()
                .moveToCategoryLaptopsComputers()
                .subcategoryList()
                .clickOnItemOfsubSubCategory()
                .verifyTabletsTitle()
                .clickCheaperButton()   //.chooseManufacturer()
                .logProducts()
                .searchSecondItem();
    }
}
