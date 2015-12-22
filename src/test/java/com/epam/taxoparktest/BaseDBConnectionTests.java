package com.epam.taxoparktest;

import com.epam.taxopark.vehicles.vehicletypes.taxoparkutils.TaxoparkUtils;
import org.testng.annotations.*;

/**
 * Created by Yahor_Faliazhynski on 12/20/2015.
 */
public class BaseDBConnectionTests {

    protected TaxoparkUtils taxoparkUtils;

    @BeforeClass
    public void classStart() {
        System.out.println("Test CLASS work was started!");
    }

    @AfterClass
    public void classEnd() {
        System.out.println("Test CLASS work was done!");
    }

}
