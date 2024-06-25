package com.zakaryan.tests.task1;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


public class LambdaTestSampleAppTest extends BaseTests {
    @Test
    @DisplayName("Тестирование списка дел \"LambdaTest Sample App\"")
    public void  test(){

        pageManager.getStartPage()
                .verifyTitle()
                .verifyRemainingItemsText()
                .verifyFirstElementNotChecked()
                .clickOnFirstItem()
                .verifyRemainingElementNotChecked()
                .clickOnRemainingItems()
                .addNewItem()
                .clickOnNewItem();
    }
}




