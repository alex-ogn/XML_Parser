
import MenuHandlers.XML_ParserMenuElements.XML_ParserMainMenuInitializer;

import XML_Elements.XML_ConcreteElements.*;
import XML_Printers.XMLBasePrinter;
import XML_Printers.XMLConsolePrinter;
import XML_Printers.XMLFilePrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PersonNote personNote = new PersonNote();
        NameNote nameNote = new NameNote("Alex");
        NameNote nameNote2 = new NameNote("Alex2");
        personNote.addChild(nameNote);
        personNote.addChild(nameNote2);

        AddressNote addressNote = new AddressNote();
        addressNote.addChild(new CountryNote("some country"));
        addressNote.addChild(new CityNote("some city"));
        personNote.addChild(addressNote);

        PeopleNote peopleNote = new PeopleNote();
        peopleNote.addChild(personNote);
        peopleNote.addChild(personNote);
//
        XMLBasePrinter printer = new XMLConsolePrinter(peopleNote);
        XMLFilePrinter filePrinter = new XMLFilePrinter(peopleNote, "C:\\Users\\Alex\\Desktop\\Уни\\2 година\\2 Семестър\\ООП\\KP\\XML Parser\\text.xml");
        try {
            printer.print();
            filePrinter.print();
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

        XML_ParserMainMenuInitializer.Initialize();

    }

}