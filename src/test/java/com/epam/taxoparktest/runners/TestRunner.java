package com.epam.taxoparktest.runners;

import com.epam.taxoparktest.listeners.TestListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Yahor_Faliazhynski on 12/19/2015.
 */
public class TestRunner {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        tng.addListener(tla);
        tng.addListener(new TestListener());

        XmlSuite suite = new XmlSuite();
        suite.setName("TempSuite");

        List<String> filesSuite = new ArrayList<>();

        filesSuite.add("./src/test/resources/suites/taxoparktest.xml");
        suite.setSuiteFiles(filesSuite);
        suite.setParallel(XmlSuite.ParallelMode.METHODS);
        suite.setThreadCount(3);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);

        tng.run();
    }
}