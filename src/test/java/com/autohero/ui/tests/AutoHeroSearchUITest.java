package com.autohero.ui.tests;

import com.autohero.pages.SearchPage;
import com.autohero.utilities.Pair;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.autohero.utilities.CollectionsUtil.isSorted;
import static org.testng.Assert.assertTrue;

public class AutoHeroSearchUITest extends BaseTest {

    SearchPage searchPage =null;

    Pair<List<Double>, List<Integer>> pair = null;

    @BeforeClass
    public void setUpTest() throws InterruptedException {
        setUp();
        searchPage = new SearchPage(driver);
        pair = getPriceListsAndYear();
    }

    @Test
    public void testResultsSortedByPriceDescending() throws InterruptedException {
        List<Double> priceList = pair.getElement0();
        assertTrue(isSorted(priceList));
    }


    @Test
    public void testResultsFilterByFirstRegistration() throws InterruptedException {
        List<Integer> yearList = pair.getElement1();
        assertTrue(yearList.stream().noneMatch(item -> item < 2015));
    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
    }


    private Pair<List<Double>, List<Integer>> getPriceListsAndYear() throws InterruptedException {
        searchPage.clickOnRegistrationDate().selectYearAs().sortBy().changePageSize();

        List<Double> priceList=new ArrayList<>();
        List<Integer> yearList = new ArrayList<>();

        Thread.sleep(3000);

        priceList.addAll(searchPage.getPrices());
        yearList.addAll(searchPage.getYears());

        int numberOfPages = searchPage.getPageLength();

        for(int pageNumber = 2; pageNumber <= numberOfPages ; pageNumber++)
        {
            searchPage.clickOnLink(pageNumber);
            Thread.sleep(2500);
            priceList.addAll(searchPage.getPrices());
            yearList.addAll(searchPage.getYears());
        }
        return  Pair.createPair(priceList, yearList);
    }


}
