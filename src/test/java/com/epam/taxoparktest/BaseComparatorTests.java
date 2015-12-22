package com.epam.taxoparktest;

import com.epam.taxopark.vehicles.vehicletypes.comparators.CarBrandComparator;
import com.epam.taxopark.vehicles.vehicletypes.comparators.CarCostComparator;
import com.epam.taxopark.vehicles.vehicletypes.comparators.FuelConsumptionComparator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Yahor_Faliazhynski on 12/21/2015.
 */
public class BaseComparatorTests {

    protected CarBrandComparator carBrandComparator;
    protected CarCostComparator carCostComparator;
    protected FuelConsumptionComparator fuelConsumptionComparator;

    @BeforeClass
    public void classStart() {
        carBrandComparator = new CarBrandComparator();
        carCostComparator = new CarCostComparator();
        fuelConsumptionComparator = new FuelConsumptionComparator();
        System.out.println("Test CLASS work was started!");
    }

    @AfterClass
    public void classEnd() {
        System.out.println("Test CLASS work was done!");
    }

}
