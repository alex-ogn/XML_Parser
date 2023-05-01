
import MenuHandlers.XML_ParserMenuElements.XML_ParserMainMenuInitializer;

import XML_Elements.XML_ConcreteElements.*;
import XML_Printers.XMLBasePrinter;
import XML_Printers.XMLConsolePrinter;
import XML_Printers.XMLFilePrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        PersonNode personNode = new PersonNode();
        NameNode nameNode = new NameNode("Alex");
        NameNode nameNode2 = new NameNode("Alex2");
        personNode.addChild(nameNode);
        personNode.addChild(nameNode2);

        AddressNode addressNode = new AddressNode();
        addressNode.addChild(new CountryNode("some country"));
        addressNode.addChild(new CityNode("some city"));
        personNode.addChild(addressNode);

        PeopleNode peopleNode = new PeopleNode();
        peopleNode.addChild(personNode);
        peopleNode.addChild(personNode);
//
        XMLBasePrinter printer = new XMLConsolePrinter(peopleNode);
        XMLFilePrinter filePrinter = new XMLFilePrinter(peopleNode, "C:\\Users\\Alex\\Desktop\\Уни\\2 година\\2 Семестър\\ООП\\KP\\XML Parser\\text.xml");
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