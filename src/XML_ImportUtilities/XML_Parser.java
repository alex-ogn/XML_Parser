package XML_ImportUtilities;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.Mapping.XML_ElementsTypesFactory;
import XML_Elements.XML_BaseElements.BaseLeafNode;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.Node;

public class XML_Parser
{
    protected String rawXML;
    private BaseMiddleNode baseMiddleNode;

    public XML_Parser(String rawXML, BaseMiddleNode baseMiddleNode) {
        this.rawXML = rawXML;
        this.baseMiddleNode = baseMiddleNode;
    }

    public boolean ParseXML()
    {
        try {
            ParseXML(baseMiddleNode, rawXML);
        }
        catch (Exception e)
        {
            System.out.println("Unable to parse xml: " + e);
        }

        return true;
    }

    private void ParseXML(BaseMiddleNode middleNode, String xml) throws Exception
    {
        xml = xml.trim();
        XML_ElementsTypes element = XML_ElementsStringSplitter.GetFirstStartTag(xml);
        if (!element.equals(middleNode.getType()))
            throw new Exception(element.name + " is different than " + middleNode.getName());

        String trimmedXML = XML_ElementsStringSplitter.TrimBeginAndEndTag(xml, middleNode.getType());
        trimmedXML = trimmedXML.trim();

        while (!trimmedXML.isEmpty()) {
            XML_ElementsTypes elementChild = XML_ElementsStringSplitter.GetFirstStartTag(trimmedXML);
            if (!middleNode.supportChild(elementChild))
                throw new Exception(middleNode.getName() + " don't support " + elementChild.name());

            Node node = XML_ElementsTypesFactory.createNode(elementChild);
            if (node instanceof BaseMiddleNode)
            {
                BaseMiddleNode childMiddleNode = (BaseMiddleNode)node;
                ParseXML(childMiddleNode, trimmedXML);
                // to do - add delete
            }
            else if(node instanceof BaseLeafNode)
            {
                BaseLeafNode childLeafNode = (BaseLeafNode)node;
                ParseXML(childLeafNode, trimmedXML);
                // to do - add delete
            }
        }
    }

    private void ParseXML(BaseLeafNode leafNode, String xml) throws Exception
    {
        xml.trim();
        XML_ElementsTypes element = XML_ElementsStringSplitter.GetFirstStartTag(xml);
        if (!element.equals(leafNode.getType()))
            throw new Exception(element.name + " is different than " + leafNode.getName());

        String trimmedXML = XML_ElementsStringSplitter.TrimBeginAndEndTag(xml, leafNode.getType());
        trimmedXML = trimmedXML.trim();

        leafNode.setStringValue(trimmedXML);
    }


}
