package com.zakaryan.tests.task2;


import org.junit.Test;


public class MospolytechTest extends BaseTests {

    @Test
    public void test2() {

        pageManager.getMospolytechStartPage()
                .verifyTitle()
                .clickScheduleButton()
                .clickLookOnTheWebsiteButton()
                .fillGroupNumber()
                .clickGroupButton();
    }
}
