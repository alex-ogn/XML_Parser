package MenuHandlers.XML_ParserMenuElements;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_FIleManagers.PeopleXML_FileManager;
import XML_Management.Person.PersonAttributeConsoleSetter;
import XML_Management.Person.PersonXPathQueriesExecutor;
import XML_Management.XML_Manager;
import XML_Printers.TextFormatPrinter.XMLConsoleTextPrinter;
import XML_Printers.XMLFormatPrinter.XMLConsolePrinter;
import java.util.Scanner;

public class XML_ParserMenuChoiceHandler
{
    public void handleChoice(XML_ParserMenuItems menuItem) throws Exception
    {
        switch (menuItem)
        {
            case OPEN:
            {
                onOpen();
                break;
            }
            case CLOSE:
            {
                onClose();
                break;
            }
            case SAVE:
            {
                onSave();
                break;
            }
            case SAVE_AS:
            {
                onSaveAs();
                break;
            }
            case HELP:
            {
                onHelp();
                break;
            }
            case EXIT:
            {
                onExit();
                break;
            }
            case TO_MAIN_MENU:
            {
                onToMainMenu();
                break;
            }
            case FILE_OPERATIONS:
            {
                onFileOperations();
                break;
            }
            case XML_OPERATIONS:
            {
                onXMLOperations();
                break;
            }
            case PRINT_XML:
            {
                onPrint();
                break;
            }
            case SELECT_XML:
            {
                onSelectXML();
                break;
            }
            case SET_XML:
            {
                onSet();
                break;
            }
            case LIST_CHILDREN_XML:
            {
                onChildren();
                break;
            }
            case CHILDREN_DESCENDANT_XML:
            {
                onChildrenDescendant();
                break;
            }
            case TEXT_XML:
            {
                onText();
                break;
            }
            case DELETE_XML:
            {
                onDelete();
                break;
            }
            case NEW_CHILD_XML:
            {
                onNewChild();
                break;
            }
            case XPATH_XML:
            {
                onXPath();
                break;
            }
            default:
            {
                break;
            }
        }
    }

    private void onExit()
    {
        System.exit(0);
    }
    private void onOpen() throws Exception
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter file location: ");
        String filePath = input.nextLine();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        fileManager.openFile(filePath);
        System.out.println("Successfully opened file.");
    }
    private void onClose() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        fileManager.closeFile();
        System.out.println("Successfully closed file.");
    }
    private void onSave() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        fileManager.saveFile();
        System.out.println("Successfully saved file.");
    }
    private void onSaveAs() throws Exception
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter file location: ");
        String filePath = input.nextLine();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        fileManager.saveAsFile(filePath);
        System.out.println("Successfully saved file.");
    }
    private void onHelp()
    {
        for (XML_ParserMenuItems menuItem : XML_ParserMenuItems.values()) {
            if (!menuItem.getDescription().isEmpty())
                System.out.println("\t" + menuItem.getName() + " - " + menuItem.getDescription());
        }
    }
    private void onToMainMenu()
    {
       // don't need to do anything
    }
    private void onFileOperations() throws Exception
    {
        XML_ParserFileOperationsMenuInitializer menuInitializer = new XML_ParserFileOperationsMenuInitializer();
        menuInitializer.Initialize();
    }
    private void onXMLOperations() throws Exception
    {
        XML_ParserXMLOperationsMenuInitializer menuInitializer = new XML_ParserXMLOperationsMenuInitializer();
        menuInitializer.Initialize();
    }
    private void onPrint() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XMLConsolePrinter printer = new XMLConsolePrinter();
        printer.print(fileManager.getNode());
    }

    private void onSelectXML() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        System.out.println("Enter key: ");
        String key = input.nextLine();
        XML_ElementsTypes keyType = XML_ElementsTypes.valueOf(key);

        XMLConsoleTextPrinter xmlConsoleTextPrinter = new XMLConsoleTextPrinter();
        xmlConsoleTextPrinter.print(xmlManager.selectById(id, keyType));
    }
    private void onChildrenDescendant() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        System.out.println("Enter index: ");
        int index = input.nextInt();

        XMLConsoleTextPrinter xmlConsoleTextPrinter = new XMLConsoleTextPrinter();
        xmlConsoleTextPrinter.print(xmlManager.getChild(id, index));
    }
    private void onDelete() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        System.out.println("Enter key: ");
        String key = input.nextLine();
        XML_ElementsTypes keyType = XML_ElementsTypes.valueOf(key);

        xmlManager.delete(id, keyType);
        System.out.println("Successfully deleted element.");
    }

    private void onText() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        xmlManager.getElementDescription(id);
    }

    private void onNewChild() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        xmlManager.addChild(id, XML_ElementsTypes.person);
        System.out.println("Successfully added element.");
    }

    private void onChildren() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        xmlManager.getElementDescription(id);
    }
    private void onSet() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        PersonAttributeConsoleSetter setter = new PersonAttributeConsoleSetter(fileManager.getNode());

        Scanner input = new Scanner( System.in );
        System.out.println("Enter ID: ");
        String id = input.nextLine();

        System.out.println("Enter key: (name, address)");
        String key = input.nextLine();
        XML_ElementsTypes keyType = XML_ElementsTypes.valueOf(key);

        setter.SetAttribute(id, keyType);
    }

    private void onXPath() throws Exception
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();

        Scanner input = new Scanner( System.in );
        System.out.println("Enter XPath: ");
        String xpath = input.nextLine();

        PersonXPathQueriesExecutor queriesExecutor = new PersonXPathQueriesExecutor(fileManager.getNode());
        queriesExecutor.executeQuery(xpath);
    }
}
