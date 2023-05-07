package XML_Printers;
import XML_Elements.XML_BaseElements.BaseMiddleNode;

public class XMLConsolePrinter extends XMLBasePrinter
{
    @Override
    protected void printString(String str) {
        System.out.print(str);
    }

    @Override
    protected void printStringNewLine(String str) {
        System.out.println(str);
    }
}
