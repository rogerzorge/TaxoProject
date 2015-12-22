package com.epam.taxoparktest;

import org.apache.derby.jdbc.EmbeddedDriver;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

/**
 * Created by Yahor_Faliazhynski on 12/19/2015.
 */
public class DBConnectionTests extends BaseDBConnectionTests {

    @Test
    public void dbCheckTest() {
        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            Connection connection = DriverManager.getConnection("jdbc:derby:my_auto;create=true;user=me;password=mine");
            boolean reachable = connection.isValid(10);// 10 sec
            assertEquals(reachable, true, "DB isn't connected!");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e + "\n");
        }
    }

}
