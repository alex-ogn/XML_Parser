package MenuHandlers.XML_ParserMenuElements.CLI;
import MenuHandlers.BaseMenu.ChoiceHandler;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_FIleManagers.PeopleXML_FileManager;
import XML_Management.Person.PersonAttributeConsoleSetter;
import XML_Management.Person.PersonXPathQueriesExecutor;
import XML_Management.XML_Manager;
import XML_Printers.TextFormatPrinter.XMLConsoleTextPrinter;
import XML_Printers.XMLFormatPrinter.XMLConsolePrinter;

public class CLIChoiceHandler implements ChoiceHandler {
    String[] command;
    CLIChoiceHandler(String[] command)
    {
        this.command = command;
    }

    @Override
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
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < command.length; i++) {
            if (!sb.toString().isEmpty())
                sb.append(" ");
            sb.append(command[i]);
        }

        String path = sb.toString();
        path.trim();
        fileManager.openFile(path);
        System.out.println("Successfully opened file.");
    }
    private void onClose() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        fileManager.closeFile();
        System.out.println("Successfully closed file.");
    }
    private void onSave() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        fileManager.saveFile();
        System.out.println("Successfully saved file.");
    }
    private void onSaveAs() throws Exception
    {
        validateOpenedFile();
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < command.length; i++) {
            if (!sb.toString().isEmpty())
                sb.append(" ");
            sb.append(command[i]);
        }

        String path = sb.toString();
        path.trim();

        fileManager.saveAsFile(path);
        System.out.println("Successfully saved file.");
    }
    private void onHelp()
    {
        for (XML_ParserMenuItems menuItem : XML_ParserMenuItems.values()) {
            if (!menuItem.getDescription().isEmpty())
                System.out.println("\t" + menuItem.getName() + " - " + menuItem.getDescription());
        }
    }

    private void onPrint() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XMLConsolePrinter printer = new XMLConsolePrinter();
        printer.print(fileManager.getNode());
    }

    private void onSelectXML() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        String id = command[1];
        String key = command[2];
        XML_ElementsTypes keyType = XML_ElementsTypes.valueOf(key);

        XMLConsoleTextPrinter xmlConsoleTextPrinter = new XMLConsoleTextPrinter();
        xmlConsoleTextPrinter.print(xmlManager.selectById(id, keyType));
    }
    private void onChildrenDescendant() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        String id = command[1];
        int index = Integer.parseInt(command[2]);

        XMLConsoleTextPrinter xmlConsoleTextPrinter = new XMLConsoleTextPrinter();
        xmlConsoleTextPrinter.print(xmlManager.getChild(id, index));
    }
    private void onDelete() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());

        String id = command[1];
        String key = command[2];
        XML_ElementsTypes keyType = XML_ElementsTypes.valueOf(key);
        xmlManager.delete(id, keyType);
        System.out.println("Successfully deleted element.");
    }

    private void onText() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());
        String id = command[1];
        xmlManager.getElementDescription(id);
    }

    private void onNewChild() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());
        String id = command[1];
        xmlManager.addChild(id, XML_ElementsTypes.person);
        System.out.println("Successfully added element.");
    }

    private void onChildren() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        XML_Manager xmlManager = new XML_Manager(fileManager.getNode());
        String id = command[1];
        xmlManager.getElementDescription(id);
    }
    private void onSet() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        PersonAttributeConsoleSetter setter = new PersonAttributeConsoleSetter(fileManager.getNode());
        String id = command[1];
        String key = command[2];
        XML_ElementsTypes keyType = XML_ElementsTypes.valueOf(key);
        setter.SetAttribute(id, keyType);

        System.out.println("Successfully set element " + key);
    }

    private void onXPath() throws Exception
    {
        validateOpenedFile();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        String xpath = command[1];
        PersonXPathQueriesExecutor queriesExecutor = new PersonXPathQueriesExecutor(fileManager.getNode());
        queriesExecutor.executeQuery(xpath);
    }

    private void validateOpenedFile() throws Exception
    {
        if (!PeopleXML_FileManager.getInstance().isFileOpen())
            throw new Exception("There isn't opened XML file.");
    }
}
