package XML_Printers;
import XML_Elements.XML_BaseElements.BaseMiddleNote;

public class XMLConsolePrinter extends XMLBasePrinter
{
    public XMLConsolePrinter(BaseMiddleNote baseMiddleNote) {
        super(baseMiddleNote);
    }

    @Override
    protected void PrintString(String str) {
        System.out.print(str);
    }

    @Override
    protected void PrintStringln(String str) {
        System.out.println(str);
    }
}
