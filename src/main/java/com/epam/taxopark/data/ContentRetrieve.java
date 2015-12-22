package com.epam.taxopark.data;

import com.epam.taxopark.vehicles.vehicletypes.Automobile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Yahor_Faliazhynski on 12/19/2015.
 */
public interface ContentRetrieve {

    List<Automobile> getContent() throws SQLException, ParserConfigurationException, IOException, SAXException;

}
