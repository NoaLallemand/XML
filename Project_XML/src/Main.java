import controler.Container;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Container.getInstance().Lecture(); //A décommenter...
        Container.getInstance().writeXML();  //A décommenter...

        System.out.println(Container.getInstance().getNbrPegi13());

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            try {
                factory.setSchema(schemaFactory.newSchema(new Source[] {
                        new StreamSource("xmlSchemaDefinition.xsd")
                }));
                SAXParser sp = factory.newSAXParser();
                sp.getXMLReader().parse("movies.xml");
            }
            catch(SAXException se) {
                System.out.println("SCHEMA : " + se.getMessage());
            }
        }
        catch (ParserConfigurationException | IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
}