package XML_Printers.TextFormatPrinter;

import XML_Elements.XML_BaseElements.BaseLeafNode;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;
import XML_Printers.Interfaces.XMLPrinter;

import java.util.List;

public abstract class XMLTextBasePrinter implements XMLPrinter
{
    @Override
    public void print(Node node) throws Exception
    {
        if (node instanceof BaseMiddleNode)
        {
            printMiddleNode((BaseMiddleNode)node, 0);
        }
        else if(node instanceof BaseLeafNode)
        {
            printLeafNode((BaseLeafNode) node, 0);
        }

    }

    public void print(List<Node> nodes) throws Exception
    {
        for (Node node:
             nodes) {
            print(node);
        }
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
                attribute.append(" with " + ((AttributeSupporter) baseMiddleNode).getAttribute().getName()
                        + " =\"" + attributeValue
                        + "\"");
        }

        printStringNewLine(taps + baseMiddleNode.getName() + attribute);

        List<Node> list =  baseMiddleNode.getValue();

        if (list.size()>0)
            printStringNewLine(taps + baseMiddleNode.getName() + " has children:");

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
    }

    private void printLeafNode(BaseLeafNode baseLeafNode, int countDept) throws Exception
    {
        String tap = "\t";
        String taps = tap.repeat(countDept);

        printString(taps + baseLeafNode.getName() + " with value: ");
        printString(baseLeafNode.getValue().toString());
        printStringNewLine(" ");
    }
}
