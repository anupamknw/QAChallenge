package com.autohero.api.tests;


import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.util.*;

import static com.autohero.utilities.CollectionsUtil.isSorted;
import static org.testng.Assert.assertTrue;

public class AutoHeroSearchAPITest extends BaseTest {

    @Test
    public void testResultsFilterByFirstRegistration()  {
        response = postRequest();

        List<Integer> list = JsonPath.parse(response).read("$.response.hits.hits[*]..firstRegistrationYear");

        assertTrue(list.stream().noneMatch(item -> item < 2015));
    }

    @Test
    public void testResultsSortedByPriceDescending() {
        response = postRequest();

        List<Integer> list = JsonPath.parse(response).read("$.response.hits.hits[*]..offerPrice.amountMinorUnits");

        assertTrue(isSorted(list));
    }

}


