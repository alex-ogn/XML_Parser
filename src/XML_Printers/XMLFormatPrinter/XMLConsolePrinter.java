package XML_Printers.XMLFormatPrinter;

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
