package com.zakaryan.framework.managers;

import com.zakaryan.framework.pages.task1.StartPage;
import com.zakaryan.framework.pages.task2.MospolytechStartPage;
import com.zakaryan.framework.pages.task2.RaspDmamiPage;
import com.zakaryan.framework.pages.task2.SchedulePage;
import com.zakaryan.framework.pages.task3.TabletsPage;
import com.zakaryan.framework.pages.task3.YaMarketStartPage;
import com.zakaryan.framework.pages.task4.*;

public class PageManager {

    private static PageManager INSTANCE = null;

    private static PageManager pageManager;

    private StartPage startPage;

    private MospolytechStartPage mospolytechStartPage;

    private SchedulePage schedulePage;

    private RaspDmamiPage raspDmamiPage;

    private YaMarketStartPage yaMarketStartPage;

    private TabletsPage tabletsPage;

    private ChessmatenokStartPage chessmatenokStartPage;

    private RaitingPage raitingPage;

    private FidePage fidePage;

    private DebutsPage debutsPage;

    private SearchResultPage searchResultPage;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }


    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MospolytechStartPage getMospolytechStartPage(){
        if (mospolytechStartPage == null) {
            mospolytechStartPage = new MospolytechStartPage();
        }
        return mospolytechStartPage;
    }

    public SchedulePage getSchedulePage(){
        if (schedulePage == null) {
            schedulePage = new SchedulePage();
        }
        return schedulePage;
    }

    public RaspDmamiPage getRaspDmamiPage(){
        if (raspDmamiPage == null) {
            raspDmamiPage = new RaspDmamiPage();
        }
        return raspDmamiPage;
    }

    public YaMarketStartPage getYaMarketStartPage(){
        if (yaMarketStartPage == null) {
            yaMarketStartPage = new YaMarketStartPage();
        }
        return yaMarketStartPage;
    }

    public TabletsPage getTabletsPage(){
        if (tabletsPage == null) {
            tabletsPage = new TabletsPage();
        }
        return tabletsPage;
    }

    public ChessmatenokStartPage getChessmatenokStartPage(){
        if (chessmatenokStartPage == null) {
            chessmatenokStartPage = new ChessmatenokStartPage();
        }
        return chessmatenokStartPage;
    }

    public RaitingPage getRaitingPage(){
        if (raitingPage == null) {
            raitingPage = new RaitingPage();
        }
        return raitingPage;
    }

    public FidePage getFidePage(){
        if (fidePage == null) {
            fidePage = new FidePage();
        }
        return fidePage;
    }

    public DebutsPage getDebutsPage(){
        if (debutsPage == null) {
            debutsPage = new DebutsPage();
        }
        return debutsPage;
    }

    public SearchResultPage getSearchResultPage(){
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }


    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }
}
