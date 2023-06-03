package XML_Printers.TextFormatPrinter;

public class XMLConsoleTextPrinter extends XMLTextBasePrinter{
    @Override
    protected void printString(String str) {
        System.out.print(str);
    }

    @Override
    protected void printStringNewLine(String str) {
        System.out.println(str);
    }
}
