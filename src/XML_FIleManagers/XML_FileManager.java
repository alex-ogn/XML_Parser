package XML_FIleManagers;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_ImportUtilities.XML_Parser;
import XML_Printers.XMLFilePrinter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public abstract class XML_FileManager<T extends BaseMiddleNode>
{
    private boolean isFileOpen;
    private String filePath;
    private T startNode;

    protected XML_FileManager(T startNode)
    {
        isFileOpen = false;
        filePath = "";
        this.startNode = startNode;
    }

    protected abstract T getNewStartNode();

    public boolean openFile(String filePath)
    {
        try {
            if (isFileOpen)
            {
                System.out.println("There is already opened file.");
                return false;
            }

            this.filePath = filePath;
            startNode = getNewStartNode();

            String xml = new String(Files.readAllBytes(Paths.get(filePath)));

            XML_Parser parser = new XML_Parser(xml, startNode);
            parser.ParseXML();
            isFileOpen = true;
        }
        catch (Exception e)
        {
            System.out.println("Unable to parse hml: " + e);
            return false;
        }

        return true;
    }

    public boolean closeFile()
    {
        if (!isFileOpen)
        {
            System.out.println("There isn't opened file.");
            return false;
        }

        startNode = getNewStartNode();
        isFileOpen = false;
        this.filePath = "";

        return true;
    }

    public boolean saveFile()
    {
        if (!isFileOpen)
        {
            System.out.println("There isn't opened file.");
            return false;
        }

        XMLFilePrinter filePrinter = new XMLFilePrinter(startNode, filePath);
        if(!filePrinter.print())
            return false;

        return true;
    }

    public boolean saveAsFile(String newFilePath)
    {
        if (!isFileOpen)
        {
            System.out.println("There isn't opened file.");
            return false;
        }

        XMLFilePrinter filePrinter = new XMLFilePrinter(startNode, newFilePath);
        if(!filePrinter.print())
            return false;

        return true;
    }

    public T getNode()
    {
        return startNode;
    }
}
