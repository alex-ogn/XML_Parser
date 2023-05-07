package XML_FIleManagers;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_ImportUtilities.XML_Parser;
import XML_Printers.XMLFilePrinter;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public void openFile(String filePath) throws Exception
    {
        if (isFileOpen)
            throw new Exception("There is already opened file.");

        this.filePath = filePath;
        startNode = getNewStartNode();

        String xml = new String(Files.readAllBytes(Paths.get(filePath)));

        XML_Parser parser = new XML_Parser(xml, startNode);
        parser.ParseXML();
        isFileOpen = true;

    }

    public boolean closeFile() throws Exception
    {
        if (!isFileOpen)
            throw new Exception("There isn't opened file.");

        startNode = getNewStartNode();
        isFileOpen = false;
        this.filePath = "";

        return true;
    }

    public void saveFile() throws Exception
    {
        if (!isFileOpen)
            throw new Exception("There isn't opened file.");

        XMLFilePrinter filePrinter = new XMLFilePrinter(filePath);
        filePrinter.print(startNode);
    }

    public void saveAsFile(String newFilePath) throws Exception
    {
        if (!isFileOpen)
            throw new Exception("There isn't opened file.");

        XMLFilePrinter filePrinter = new XMLFilePrinter(newFilePath);
        filePrinter.print(startNode);
    }

    public T getNode()
    {
        return startNode;
    }
}
