package tests;

import base.BaseTest;
import pages.ProductPage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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