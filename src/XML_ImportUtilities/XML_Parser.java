package XML_ImportUtilities;

import Utilities.ElementIdGenerator;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.Mapping.XML_ElementsTypesFactory;
import XML_Elements.XML_BaseElements.BaseLeafNode;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;

public class XML_Parser
{
    protected String rawXML;
    private BaseMiddleNode baseMiddleNode;
    private ElementIdGenerator elementIdGenerator;
    public XML_Parser(String rawXML, BaseMiddleNode baseMiddleNode) {
        this.rawXML = rawXML;
        this.baseMiddleNode = baseMiddleNode;
    }
    public void parseXML() throws Exception
    {
        elementIdGenerator = new ElementIdGenerator();

        rawXML = prepareXMLForParsing(rawXML);
        parseXML(baseMiddleNode, rawXML);
    }
    private String prepareXMLForParsing(String xml)
    {
        xml = xml.replaceAll("\n", "");
        xml = xml.replaceAll("\t", "");
        xml = xml.replaceAll("\r", "");

        return xml;
    }
    private void parseXML(BaseMiddleNode middleNode, String xml) throws Exception
    {
        xml = xml.trim();
        XML_ElementsTypes element = XML_ElementsStringSplitter.GetFirstStartTag(xml);
        if (!element.equals(middleNode.getType()))
            throw new Exception(element.name + " is different than " + middleNode.getName());

        if (middleNode instanceof AttributeSupporter)
        {
            String attributeValue = XML_ElementsStringSplitter.GetAttributeValue(xml);

            if (!attributeValue.isEmpty())
                ((AttributeSupporter) middleNode).setAttribute(elementIdGenerator.generateId(attributeValue));
            else
                ((AttributeSupporter) middleNode).setAttribute(elementIdGenerator.generateId());

        }

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
                parseXML(childMiddleNode, trimmedXML);
            }
            else if(node instanceof BaseLeafNode)
            {
                BaseLeafNode childLeafNode = (BaseLeafNode)node;
                parseXML(childLeafNode, trimmedXML);
            }

            trimmedXML = XML_ElementsStringSplitter.TrimFirstNodeOfType(trimmedXML, elementChild);
            trimmedXML = trimmedXML.trim();

            middleNode.addChild(node);
        }
    }
    private void parseXML(BaseLeafNode leafNode, String xml) throws Exception
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
