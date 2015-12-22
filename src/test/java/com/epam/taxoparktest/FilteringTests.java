package com.epam.taxoparktest;

import com.epam.taxopark.vehicles.vehicletypes.Automobile;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.Minivan;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.PassengerCar;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.Suv;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

/**
 * Created by Yahor_Faliazhynski on 12/21/2015.
 */
public class FilteringTests extends BaseFilteringTest {

    @Test(groups = "filtering", dataProvider = "CarCostFiltDP")
    public void testCarCostFiltering(int low, int high, List<Automobile> expected) {
        List<Automobile> result = taxoparkUtils.carCostFiltering(testListAll, low, high);
        assertEquals(result, expected, "Invalid result of compare() method");
    }

    @DataProvider(name = "CarCostFiltDP")
    public Object[][] attributesForCarCostFiltering() {
        return new Object[][] {
                {9999, 10001, testList0},
                {19999, 20001, testList1},
                {29999, 30001, testList2},
                {10000, 20000, testList01},
                {20000, 30000, testList12},
                {10000, 30000, testListAll},
                {0, 50000, testListAll},
                {40000, 50000, testListEmpty}
        };
    }

    @Test(groups = "filtering", dataProvider = "FuelConsumptionFiltDP", priority = 1)
    public void testFuelConsumptionFiltering(int low, int high, List<Automobile> expected) {
        List<Automobile> testListAll2 = new ArrayList<>();
        testListAll2.addAll(testList0);
        testListAll2.addAll(testList1);
        testListAll2.addAll(testList2);
        List<Automobile> result = taxoparkUtils.fuelConsumptionFiltering(testListAll2, low, high);
        assertEquals(result, expected, "Invalid result of compare() method");
    }

    @DataProvider(name = "FuelConsumptionFiltDP")
    public Object[][] attributesForFuelConsumptionFiltering() {
        return new Object[][] {
                {9, 11, testList1},
                {5, 6, testList0},
                {14, 16, testList2},
                {5, 10, testList01},
                {10, 15, testList12},
                {5, 15, testListAll},
                {15, 15, testList2},
                {0, 20, testListAll},
                {30, 50, testListEmpty}
        };
    }
}
