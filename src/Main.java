
import MenuHandlers.BaseMenu.Menu;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMainMenuInitializer;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenu;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;
import XML_Elements.XML_ConcreteElements.NameNote;
import XML_Elements.XML_ConcreteElements.PersonNote;
import XML_Printers.XMLBasePrinter;
import XML_Printers.XMLConsolePrinter;
import XML_Printers.XMLFilePrinter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //PersonNote personNote = new PersonNote();
        //NameNote nameNote = new NameNote("Alex");
        //NameNote nameNote2 = new NameNote("Alex2");
        //personNote.addChild(nameNote);
        //personNote.addChild(nameNote2);
//
        //XMLBasePrinter printer = new XMLConsolePrinter(personNote);
        //XMLFilePrinter filePrinter = new XMLFilePrinter(personNote, "C:\\Users\\Alex\\Desktop\\Уни\\2 година\\2 Семестър\\ООП\\KP\\XML Parser\\text.xml");
        //try {
        //    printer.print();
        //    filePrinter.print();
        //}
        //catch (Exception e)
        //{
        //    System.out.print(e);
        //}

        XML_ParserMainMenuInitializer.Initialize();

    }

}