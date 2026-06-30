package tests;

import base.BaseTest;
import pages.ProductPage;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SortProductTest extends BaseTest {

    @Test
    public void verifyPriceLowToHigh() {

        ProductPage productPage = new ProductPage(page);

        productPage.sortByLowToHigh();

        List<Double> actualPrices = productPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);

        Collections.sort(expectedPrices);

        assertEquals(expectedPrices, actualPrices);
    }
}