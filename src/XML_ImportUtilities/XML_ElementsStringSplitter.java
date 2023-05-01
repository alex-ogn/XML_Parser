package XML_ImportUtilities;

import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;
import XML_Elements.Mapping.XML_ElementsTypes;

public class XML_ElementsStringSplitter
{
    private static char startTagBegining = '<';
    private static String endTagBegining = "</";
    private static char tagEnd = '>';

    public static XML_ElementsTypes GetFirstStartTag(String xml) throws Exception
    {
        if (xml.charAt(0) != startTagBegining)
            throw new Exception("'<' isn't found");

        StringBuilder nodeName = new StringBuilder();

        for (int i = 1; i < xml.length(); i++) {
            char symbol = xml.charAt(i);
            if (symbol == ' ' || symbol == '>')
                break;

            nodeName.append(symbol);
        }

        for (XML_ElementsTypes element : XML_ElementsTypes.values())
        {
            if (nodeName.toString().equals(element.name()))
                return element;
        }

        throw new Exception("XML element " + nodeName + " isn't found");
    }

    public static String TrimFirstNodeOfType(String xml, XML_ElementsTypes elementType) throws Exception
    {
        int startIndex = xml.indexOf(startTagBegining + elementType.name());
        int endIndex = xml.indexOf(getEndTag(elementType)) + getEndTag(elementType).length();

        String trimmedXML = xml.substring(0, startIndex) + xml.substring(endIndex);

        return trimmedXML;
    }

    public static String TrimBeginAndEndTag(String xml, XML_ElementsTypes elementType) throws Exception
    {
        int startIndex = xml.indexOf(tagEnd);
        if (startIndex <= 0)
            throw new Exception(tagEnd + " isn't found");

        String endTag = getEndTag(elementType);
        int endIndex = xml.indexOf(endTag);
        if (endIndex <= 0)
            throw new Exception(endTag + " isn't found");

        final String trimmedXML = xml.substring(startIndex + 1, endIndex);

        return trimmedXML;
    }

    public static String getEndTag(XML_ElementsTypes XmlElement)
    {
        return endTagBegining + XmlElement.name() + tagEnd;
    }

    public static String getStartTag(XML_ElementsTypes XmlElement)
    {
        return startTagBegining + XmlElement.name() + tagEnd;
    }
}
