import controler.Container;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Container.getInstance().Lecture();
        Container.getInstance().writeXML();
    }
}