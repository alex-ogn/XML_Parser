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
    public void Print()
    {
        printMiddleNote(baseMiddleNote, 0);
    }

    protected abstract void PrintString(String str);
    protected abstract void PrintStringln(String str);
    private void printMiddleNote(BaseMiddleNote baseMiddleNote, int countDept)
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        PrintStringln(taps + "<" + baseMiddleNote.getName() + ">");

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

        PrintStringln(taps + "</" + baseMiddleNote.getName() + ">");
    }

    private void printLeafNote(BaseLeafNote baseLeafNote, int countDept)
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        PrintString(taps + "<" + baseLeafNote.getName() + ">");

        PrintString(baseLeafNote.getValue().toString());

        PrintStringln("</" + baseLeafNote.getName() + ">");
    }
}
