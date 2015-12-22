package com.epam.taxoparktest;

import com.epam.taxopark.vehicles.vehicletypes.Automobile;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.Minivan;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.PassengerCar;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.Suv;
import com.epam.taxopark.vehicles.vehicletypes.comparators.CarBrandComparator;
import com.epam.taxopark.vehicles.vehicletypes.comparators.CarCostComparator;
import com.epam.taxopark.vehicles.vehicletypes.comparators.FuelConsumptionComparator;
import com.epam.taxopark.vehicles.vehicletypes.taxoparkutils.TaxoparkUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yahor_Faliazhynski on 12/21/2015.
 */
public class BaseFilteringTest {

    protected List<Automobile> testListEmpty = new ArrayList<>();
    protected List<Automobile> testListAll = new ArrayList<>();
    protected List<Automobile> testList0 = new ArrayList<>();
    protected List<Automobile> testList1 = new ArrayList<>();
    protected List<Automobile> testList2 = new ArrayList<>();
    protected List<Automobile> testList01 = new ArrayList<>();
    protected List<Automobile> testList02 = new ArrayList<>();
    protected List<Automobile> testList12 = new ArrayList<>();

    protected TaxoparkUtils taxoparkUtils;

    @BeforeClass
    public void classStart() {

        testList0.add(new PassengerCar("Passenger car 01", 10000, 5.6f, false, 5));
        testList1.add(new Minivan("Minivan 01", 20000, 10f, false, 7));
        testList2.add(new Suv("Suv 01", 30000, 15f, 5));
        testList01.addAll(testList0);
        testList01.addAll(testList1);
        testList02.addAll(testList0);
        testList02.addAll(testList2);
        testList12.addAll(testList1);
        testList12.addAll(testList2);

        testListAll.addAll(testList0);
        testListAll.addAll(testList1);
        testListAll.addAll(testList2);

        taxoparkUtils = new TaxoparkUtils();

        System.out.println("Test CLASS work was started!");
    }

    @AfterClass
    public void classEnd() {
        System.out.println("Test CLASS work was done!");
    }

}
