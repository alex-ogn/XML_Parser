package XML_Printers;
import XML_Elements.XML_BaseElements.BaseLeafNode;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;

import java.util.List;

public abstract class XMLBasePrinter
{
    public boolean print(Node node) throws Exception
    {
        beforePrint();
        if (node instanceof BaseMiddleNode)
        {
            printMiddleNode((BaseMiddleNode)node, 0);
        }
        else if(node instanceof BaseLeafNode)
        {
            printLeafNode((BaseLeafNode) node, 0);
        }
        afterPrint();

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
    private void printMiddleNode(BaseMiddleNode baseMiddleNode, int countDept) throws Exception
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        StringBuilder attribute = new StringBuilder("");

        if (baseMiddleNode instanceof AttributeSupporter)
        {
            String attributeValue = ((AttributeSupporter) baseMiddleNode).getAttribute().getValue();
            if (!attributeValue.isEmpty())
                attribute.append(((AttributeSupporter) baseMiddleNode).getAttribute().getName()
                    + " =\"" + attributeValue
                    + "\"");
        }

        printStringNewLine(taps + "<" + baseMiddleNode.getName() + attribute +">");

        List<Node> list =  baseMiddleNode.getValue();

        for (int i = 0; i < list.size(); i++)
        {
            Node node = list.get(i);
            if (node instanceof BaseMiddleNode)
            {
                printMiddleNode((BaseMiddleNode) node, countDept + 1);
            }
            else if(node instanceof BaseLeafNode)
            {
                printLeafNode((BaseLeafNode) node, countDept + 1);
            }
        }

        printStringNewLine(taps + "</" + baseMiddleNode.getName() + ">");
    }

    private void printLeafNode(BaseLeafNode baseLeafNode, int countDept) throws Exception
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        printString(taps + "<" + baseLeafNode.getName() + ">");

        printString(baseLeafNode.getValue().toString());

        printStringNewLine("</" + baseLeafNode.getName() + ">");
    }
}
