package controler;

import Modele.MovieHandler;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

public class MySAXParser {
    public void parse(String xmlFilePath, String xsdFilePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            try {
                factory.setSchema(schemaFactory.newSchema(new Source[] {
                        new StreamSource(xsdFilePath)
                }));
                SAXParser sp = factory.newSAXParser();
                sp.parse("movies.xml", new MovieHandler());
            }
            catch(SAXException se) {
                System.out.println("SCHEMA : " + se.getMessage());
            }
        }
        catch (ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void parseDTD() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            SAXParser sp = factory.newSAXParser();
            sp.parse("movies.xml" , new MovieHandler());
        }
        catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
