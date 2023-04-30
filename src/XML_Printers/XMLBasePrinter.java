package XML_Printers;
import XML_Elements.XML_BaseElements.BaseLeafNote;
import XML_Elements.XML_BaseElements.BaseMiddleNote;
import XML_Elements.XML_Interfaces.Note;

import java.util.List;

public abstract class XMLBasePrinter
{
    private BaseMiddleNote baseMiddleNote;

    public XMLBasePrinter(BaseMiddleNote baseMiddleNote)
    {
        this.baseMiddleNote = baseMiddleNote;
    }
    public boolean print()
    {
        try {
            beforePrint();
            printMiddleNote(baseMiddleNote, 0);
            afterPrint();
        }
        catch (Exception e)
        {
            System.out.println("Error printing the file.");
            return false;
        }

        return true;
    }

    protected void beforePrint() throws Exception
    {

    }

    protected void afterPrint() throws Exception
    {

    }

    protected abstract void printString(String str) throws Exception;
    protected abstract void printStringNewLine(String str) throws Exception;
    private void printMiddleNote(BaseMiddleNote baseMiddleNote, int countDept) throws Exception
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        printStringNewLine(taps + "<" + baseMiddleNote.getName() + ">");

        List<Note> list =  baseMiddleNote.getValue();

        for (int i = 0; i < list.size(); i++)
        {
            Note note = list.get(i);
            if (note instanceof BaseMiddleNote)
            {
                printMiddleNote((BaseMiddleNote)note, countDept + 1);
            }
            else if(note instanceof BaseLeafNote)
            {
                printLeafNote((BaseLeafNote)note, countDept + 1);
            }
        }

        printStringNewLine(taps + "</" + baseMiddleNote.getName() + ">");
    }

    private void printLeafNote(BaseLeafNote baseLeafNote, int countDept) throws Exception
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        printString(taps + "<" + baseLeafNote.getName() + ">");

        printString(baseLeafNote.getValue().toString());

        printStringNewLine("</" + baseLeafNote.getName() + ">");
    }
}
