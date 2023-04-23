
import XML_Elements.XML_ConcreteElements.NameNote;
import XML_Elements.XML_ConcreteElements.PersonNote;
import XML_Printers.XMLBasePrinter;
import XML_Printers.XMLConsolePrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PersonNote personNote = new PersonNote();
        NameNote nameNote = new NameNote("Alex");
        NameNote nameNote2 = new NameNote("Alex2");
        personNote.addChild(nameNote);
        personNote.addChild(nameNote2);

        XMLBasePrinter printer = new XMLConsolePrinter(personNote);
        printer.Print();
    }

}