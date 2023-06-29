package XML_Management.Person;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_ConcreteElements.Nodes.*;
import XML_Elements.XML_Interfaces.Node;
import XML_Management.XML_Manager;
import java.util.Scanner;

public class PersonAttributeConsoleSetter {
    private XML_Manager manager;
    public PersonAttributeConsoleSetter(PeopleNode baseMiddleNode) {
        this.manager = new XML_Manager(baseMiddleNode);
    }

    private String getUserInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String input = scanner.nextLine();

        return input;
    }
    public void SetAttribute(String id, XML_ElementsTypes keyType) throws Exception {
        PersonNode person = (PersonNode) manager.getNode(id);

        if (keyType.equals(XML_ElementsTypes.name))
            SetName(person);
        else if (keyType.equals(XML_ElementsTypes.address))
            SetAddress(person);
        else
            throw new Exception("Person do not support " + keyType);

    }
    private void SetName(PersonNode person) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = getUserInput();

        NameNode nameNode = new NameNode(name);
        person.addChild(nameNode);
    }
    private void SetAddress(PersonNode person) throws Exception {

        Scanner input = new Scanner(System.in);
        String answer;

        do {
            System.out.println("Do you want to add new address: y/n");
            answer = getUserInput();
        } while (!answer.equals("y") && !answer.equals("n"));

        if (answer.equals("y"))
            AddAddress(person);
        else
            SetAddressByIndex(person);
    }
    private void SetAddressByIndex(PersonNode person) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter address index: ");
        int index = Integer.parseInt(getUserInput());

        AddressNode newAddress = GetNewAddress();
        AddressNode oldAddress = person.GetAddresByIndex(index);

        for (Node node:
                newAddress.getValue()) {
            oldAddress.addChild(node);
        }
    }
    private AddressNode GetNewAddress() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter country name: ");
        String countryName = getUserInput();

        System.out.println("Enter city name: ");
        String cityName = getUserInput();

        AddressNode addressNode = new AddressNode();
        addressNode.addChild(new CityNode(cityName));
        addressNode.addChild(new CountryNode(countryName));

        return addressNode;
    }
    private void AddAddress(PersonNode person) throws Exception {
        person.addChild(GetNewAddress());
    }
}