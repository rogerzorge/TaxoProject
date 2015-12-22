package com.epam.taxoparktest;

import com.epam.taxopark.vehicles.vehicletypes.Automobile;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.Minivan;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.PassengerCar;
import com.epam.taxopark.vehicles.vehicletypes.autotypes.Suv;
import com.epam.taxopark.vehicles.vehicletypes.comparators.CarBrandComparator;
import com.epam.taxopark.vehicles.vehicletypes.comparators.CarCostComparator;
import com.epam.taxopark.vehicles.vehicletypes.comparators.FuelConsumptionComparator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Yahor_Faliazhynski on 12/21/2015.
 */
public class ComparatorTests extends BaseComparatorTests {

    @Test(groups = "comparator", dataProvider = "CarBrandDP")
    public void testCarBrandComparator(Automobile auto1, Automobile auto2, int expected) {
        int result = carBrandComparator.compare(auto1, auto2);
        assertEquals(result, expected, "Invalid result of compare() method");
    }

    @DataProvider(name = "CarBrandDP")
    public Object[][] attributesForCarBrandComparator() {
        return new Object[][] {
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 5), new PassengerCar("Passenger car 02", 10000, 10f, false, 5), -1},
                {new PassengerCar("Passenger car 02", 10000, 10f, false, 5), new PassengerCar("Passenger car 01", 10000, 10f, false, 5), 1},
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 5), new Minivan("Minivan 01", 10000, 10f, false, 7), 3},
                {new Minivan("Minivan 01", 10000, 10f, false, 7), new PassengerCar("Passenger car 01", 10000, 10f, false, 5), -3},
                {new Suv("Suv 01", 10000, 10f, 5), new PassengerCar("Passenger car 01", 10000, 10f, false, 5), 3},
                {new Suv("Suv 01", 10000, 10f, 5), new Minivan("Minivan 01", 10000, 10f, false, 5), 6},
                {new Minivan("Minivan 01", 10000, 10f, false, 7), new Suv("Suv 01", 10000, 10f, 5), -6},
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 7), new Suv("Suv 01", 10000, 10f, 5), -3}
        };
    }

    @Test(groups = "comparator", dataProvider = "CarCostDP")
    public void testCarCostComparator(Automobile auto1, Automobile auto2, int expected) {
        int result = carCostComparator.compare(auto1, auto2);
        assertEquals(result, expected, "Invalid result of compare() method");
    }

    @DataProvider(name = "CarCostDP")
    public Object[][] attributesForCarCostComparator() {
        return new Object[][] {
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 5), new PassengerCar("Passenger car 02", 10000, 10f, false, 5), 0},
                {new PassengerCar("Passenger car 02", 10001, 10f, false, 5), new PassengerCar("Passenger car 01", 10000, 10f, false, 5), -1},
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 5), new Minivan("Minivan 01", 10001, 10f, false, 7), 1},
                {new Minivan("Minivan 01", 12345, 10f, false, 7), new PassengerCar("Passenger car 01", 9876, 10f, false, 5), -2469},
                {new Suv("Suv 01", 9876, 10f, 5), new PassengerCar("Passenger car 01", 12345, 10f, false, 5), 2469}
        };
    }

    @Test(groups = "comparator", dataProvider = "FuelConsumptionDP")
    public void testFuelConsumptionComparator(Automobile auto1, Automobile auto2, int expected) {
        int result = fuelConsumptionComparator.compare(auto1, auto2);
        assertEquals(result, expected, "Invalid result of compare() method");
    }

    @DataProvider(name = "FuelConsumptionDP")
    public Object[][] attributesForFuelConsumptionComparator() {
        return new Object[][] {
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 5), new PassengerCar("Passenger car 02", 10000, 10f, false, 5), 0},
                {new PassengerCar("Passenger car 02", 10001, 10.1f, false, 5), new PassengerCar("Passenger car 01", 10000, 10f, false, 5), 1},
                {new PassengerCar("Passenger car 01", 10000, 10f, false, 5), new Minivan("Minivan 01", 10001, 10.1f, false, 7), -1},
                {new Minivan("Minivan 01", 12345, 10.12345f, false, 7), new PassengerCar("Passenger car 01", 9876, 10f, false, 5), 1},
                {new Suv("Suv 01", 9876, 10f, 5), new PassengerCar("Passenger car 01", 12345, 10.12345f, false, 5), -1}
        };
    }

}
