package XML_FIleManagers;
import XML_Elements.XML_BaseElements.BaseMiddleNote;
import XML_Printers.XMLFilePrinter;

public abstract class XML_FileManager<T extends BaseMiddleNote>
{
    private boolean isFileOpen;
    private String filePath;
    private T startNote;

    protected XML_FileManager(T startNote)
    {
        isFileOpen = false;
        filePath = "";
        this.startNote = startNote;
    }

    protected abstract T getNewStartNote();

    public boolean openFile(String filePath)
    {
        if (!isFileOpen)
        {
            System.out.println("There is not opened file.");
            return false;
        }

        this.filePath = filePath;

        // to do

        return true;
    }

    public boolean closeFile()
    {
        if (!isFileOpen)
        {
            System.out.println("There is not opened file.");
            return false;
        }

        startNote = getNewStartNote();
        isFileOpen = false;
        this.filePath = "";

        return true;
    }

    public boolean saveFile()
    {
        if (!isFileOpen)
        {
            System.out.println("There is not opened file.");
            return false;
        }

        XMLFilePrinter filePrinter = new XMLFilePrinter(startNote, filePath);
        if(!filePrinter.print())
            return false;

        return true;
    }

    public boolean saveAsFile(String newFilePath)
    {
        if (!isFileOpen)
        {
            System.out.println("There is not opened file.");
            return false;
        }

        XMLFilePrinter filePrinter = new XMLFilePrinter(startNote, newFilePath);
        if(!filePrinter.print())
            return false;

        return true;
    }
}
