package MenuHandlers.XML_ParserMenuElements;
import XML_FIleManagers.PeopleXML_FileManager;
import XML_Printers.XMLConsolePrinter;

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
                break;
            }
            case SET_XML:
            {
                break;
            }
            case LIST_CHILDREN_XML:
            {
                break;
            }
            case CHILDREN_DESCENDANT_XML:
            {
                break;
            }
            case TEXT_XML:
            {
                break;
            }
            case DELETE_XML:
            {
                break;
            }
            case NEW_CHILD_XML:
            {
                break;
            }
            case XPATH_XML:
            {
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
}
