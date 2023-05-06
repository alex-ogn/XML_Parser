package MenuHandlers.XML_ParserMenuElements;
import XML_FIleManagers.PeopleXML_FileManager;
import XML_Printers.XMLBasePrinter;
import XML_Printers.XMLConsolePrinter;

import java.util.Scanner;

public class XML_ParserMenuChoiceHandler
{
    public void handleChoice(XML_ParserMenuItems menuItem)
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
    private void onOpen()
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter file location: ");
        String filePath = input.nextLine();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        if(fileManager.openFile(filePath))
            System.out.println("Successfully opened file.");

        //to do remove
        XMLBasePrinter printer = new XMLConsolePrinter(fileManager.getNode());
        printer.print();

    }
    private void onClose()
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        if(fileManager.closeFile())
            System.out.println("Successfully closed file.");

    }
    private void onSave()
    {
        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        if(fileManager.saveFile())
            System.out.println("Successfully saved file.");
    }
    private void onSaveAs()
    {
        Scanner input = new Scanner( System.in );
        System.out.println("Enter file location: ");
        String filePath = input.nextLine();

        PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
        if(fileManager.saveAsFile(filePath))
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
    private void onFileOperations()
    {
        XML_ParserFileOperationsMenuInitializer menuInitializer = new XML_ParserFileOperationsMenuInitializer();
        menuInitializer.Initialize();
    }
    private void onXMLOperations()
    {
        XML_ParserXMLOperationsMenuInitializer menuInitializer = new XML_ParserXMLOperationsMenuInitializer();
        menuInitializer.Initialize();
    }
}
