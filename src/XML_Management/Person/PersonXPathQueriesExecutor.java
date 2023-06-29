package XML_Management.Person;
import XML_Elements.Mapping.XML_AttributeTypes;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_ConcreteElements.Nodes.AddressNode;
import XML_Elements.XML_ConcreteElements.Nodes.NameNode;
import XML_Elements.XML_ConcreteElements.Nodes.PeopleNode;
import XML_Elements.XML_ConcreteElements.Nodes.PersonNode;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;
import XML_Printers.TextFormatPrinter.XMLConsoleTextPrinter;
import java.util.ArrayList;
import java.util.List;

public class PersonXPathQueriesExecutor {
    private final PeopleNode people;
    public PersonXPathQueriesExecutor(PeopleNode people) {
        this.people = people;
    }
    private XML_ElementsTypes getFirstElementsType(String str) throws Exception
    {
        XML_ElementsTypes type;
        if(str.startsWith(XML_ElementsTypes.name.toString()))
            type = XML_ElementsTypes.name;
        else if(str.startsWith(XML_ElementsTypes.address.toString()))
            type = XML_ElementsTypes.address;
        else throw new Exception("Unidentified symbols - " + str);

        return type;
    }
    public void executeQuery(String xpath) throws Exception {

        xpath = xpath.trim();

        if (xpath.equals(XML_ElementsTypes.person.toString()))
            printAllPeople();

        xpath = xpath.substring(XML_ElementsTypes.person.toString().length(), xpath.length());

        char symbol = xpath.toCharArray()[0];
        if (symbol == '/')
        {
            xpath = xpath.substring(1, xpath.length());
            printAllListedElements(xpath);
        }
        else if (symbol == '(')
        {
            if (xpath.equals(getIdentificationCondition()))
            {
                printAllIdentifications();
            }
            else
            {
                xpath = xpath.substring(1, xpath.length());
                printAllElementsByCondition(xpath);
            }
        }
        else
        {
            throw new Exception("Unidentified symbol - " + symbol);
        }
    }

    private void printAllPeople() throws Exception
    {
        XMLConsoleTextPrinter printer = new XMLConsoleTextPrinter();
        printer.print(people);
    }
    public List<Node> getAllNodesFromType(XML_ElementsTypes type)
    {
        List<Node> nodes = new ArrayList<>();

        for (Node person:
                people.getValue()) {
            for (Node node:
                    ((PersonNode)person).getValue()) {
                if (node.getType() == type)
                    nodes.add(node);
            }
        }

        return nodes;
    }

    public List<Node> getAllNodesFromType(List<PersonNode> personNodeList, XML_ElementsTypes type)
    {
        List<Node> nodes = new ArrayList<>();

        for (PersonNode person:
                personNodeList) {
            for (Node node: person.getValue()) {
                if (node.getType() == type)
                    nodes.add(node);
            }
        }

        return nodes;
    }
    public Node getNodeAtIndex(XML_ElementsTypes type, int index)
    {
        List<Node> nodes = getAllNodesFromType(type);
        return nodes.get(index);
    }
    private void printAllListedElements(String xpath) throws Exception
    {
        XMLConsoleTextPrinter printer = new XMLConsoleTextPrinter();
        XML_ElementsTypes type = getFirstElementsType(xpath);
        List<Node> nodes = getAllNodesFromType(type);
        xpath = xpath.substring(type.toString().length(), xpath.length());

        if(xpath.isEmpty())
        {
            printer.print(nodes);
        }
        else
        {
            xpath = xpath.replace("[", "");
            xpath = xpath.replace("]", "");

            int index = Integer.parseInt(xpath);
            printer.print(nodes.get(index));
        }
    }
    private void printAllElementsByCondition(String xpath) throws Exception
    {
        XML_ElementsTypes type = getFirstElementsType(xpath);
        xpath = xpath.substring(type.toString().length(), xpath.length());
        char symbol = xpath.toCharArray()[0];
        if (symbol != '=')
            throw new Exception("Unidentified symbol - " + symbol);

        xpath = xpath.substring(2, xpath.length());

        int second = xpath.indexOf('"');
        String elementValue = xpath.substring(0,second);

        List<PersonNode> personNodeList = getPeopleFromCondition(type, elementValue);
        xpath = xpath.substring(second + 3, xpath.length());
        XML_ElementsTypes typeToGet = getFirstElementsType(xpath);

        List<Node> nodes = getAllNodesFromType(personNodeList, typeToGet);
        XMLConsoleTextPrinter printer = new XMLConsoleTextPrinter();
        printer.print(nodes);
    }

    private List<PersonNode> getPeopleFromCondition(XML_ElementsTypes type, String elementValue) throws Exception
    {
        List<PersonNode> personNodeList = new ArrayList<>();
        for (Node person: people.getValue())
        {
            for (Node node : ((PersonNode) person).getValue())
            {
                if (type == XML_ElementsTypes.address)
                {
                    if(!(node instanceof AddressNode))
                        continue;

                    for (Node addressNode : ((AddressNode) node).getValue()) {
                        if (addressNode.getValue().equals(elementValue))
                        {
                            personNodeList.add(((PersonNode) person));
                            break;
                        }
                    }
                }
                else if (type == XML_ElementsTypes.name)
                {
                    if(!(node instanceof NameNode))
                       continue;

                    if (node.getValue().equals(elementValue))
                    {
                        personNodeList.add(((PersonNode) person));
                        continue;
                    }
                }

                if(personNodeList.contains(person))
                    break;

            }
        }

        return personNodeList;
    }
    private void printAllIdentifications() throws Exception
    {
        for (Node person:
                people.getValue()) {
            XMLConsoleTextPrinter consoleTextPrinter = new XMLConsoleTextPrinter();
            consoleTextPrinter.printID((AttributeSupporter) person);
        }
    }
    private String getIdentificationCondition()
    {
        return "(@" + XML_AttributeTypes.id + ")";
    }
}