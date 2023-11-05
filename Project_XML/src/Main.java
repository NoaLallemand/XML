import controler.Container;
import controler.MySAXParser;

public class Main {
    public static void main(String[] args) {
        Container.getInstance().Lecture(); //A décommenter...
        Container.getInstance().writeXML();  //A décommenter...

        System.out.println(Container.getInstance().getNbrPegi13());

        MySAXParser ps = new MySAXParser();
        ps.parse("movies.xml", "movies.xsd");
        //ps.parseDTD();
    }
}