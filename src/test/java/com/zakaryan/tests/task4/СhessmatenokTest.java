package com.zakaryan.tests.task4;

import com.zakaryan.tests.task4.BaseTests;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class СhessmatenokTest extends BaseTests {

    @Test
    @DisplayName("Тестирование сайта Шахматы с Жориком (Переход на страницу оплаты).")
    public void test(){
        pageManager.getChessmatenokStartPage()
                .verifyPage()
                .clickOnRatingButton()
                .verifyPage()
                .clickPlayerButton()
                .verifyName();
    }

    @Test
    @DisplayName("Тестирование сайта Шахматы с Жориком (Переход на страницу дебюта).")
    public void test2(){
        pageManager.getChessmatenokStartPage()
                .clickOnGambitsButton()
                .verifyDebutPage()
                .clickOnLondonSystemButton();
    }


    @Test
    @DisplayName("Тестирование сайта Шахматы с Жориком (Поиск по сайту).")
    public void test3(){
        pageManager.getChessmatenokStartPage()
                .fillInput()
                .verifySearchResultPage()
                .checkResultsText();
    }
}
