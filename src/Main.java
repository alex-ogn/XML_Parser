
import MenuHandlers.BaseMenu.Menu;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenu;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;
import XML_Elements.XML_ConcreteElements.NameNote;
import XML_Elements.XML_ConcreteElements.PersonNote;
import XML_Printers.XMLBasePrinter;
import XML_Printers.XMLConsolePrinter;

import java.util.ArrayList;

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

        ArrayList<XML_ParserMenuItems> menuItmens = new ArrayList<>();
        menuItmens.add(XML_ParserMenuItems.SAVE_AS);
        menuItmens.add(XML_ParserMenuItems.CLOSE);
        menuItmens.add(XML_ParserMenuItems.SAVE);
        menuItmens.add(XML_ParserMenuItems.EXIT);

        Menu menu = new XML_ParserMenu(menuItmens);
        while (true)
        {
            try {
               // Runtime.getRuntime().exec("cls");
                menu.show();
                menu.executeChoice();
            }
            catch (Exception e)
            {

            }

        }

    }

}