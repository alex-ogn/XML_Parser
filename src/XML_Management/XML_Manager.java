package XML_Management;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.Mapping.XML_ElementsTypesFactory;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;
import XML_Printers.TextFormatPrinter.XMLConsoleTextPrinter;

import java.util.List;

public class XML_Manager
{
    private BaseMiddleNode baseMiddleNode;

    public XML_Manager(BaseMiddleNode baseMiddleNode) {
        this.baseMiddleNode = baseMiddleNode;
    }

    public Node selectById(String id, XML_ElementsTypes elementsTypes) throws Exception
    {
        List<Node> list =  baseMiddleNode.getValue();

        for (int i = 0; i < list.size(); i++)
        {
            Node node = list.get(i);

            if (!(node instanceof AttributeSupporter))
                throw new Exception("The element does not support ID.");

            if (!(((AttributeSupporter) node).getAttribute().getValue().equals(id)))
                continue;

            if (!(node instanceof BaseMiddleNode))
                throw new Exception("The element does not support key element.");

            BaseMiddleNode baseMiddleNodeChild = (BaseMiddleNode)node;

            for (Node chilsNode:
                    baseMiddleNodeChild.getValue())
            {
                if (chilsNode.getType().equals(elementsTypes))
                {
                    return chilsNode;
                }
            }

            throw new Exception("Element with key " + elementsTypes + " is not supported.");
        }

        throw new Exception("Element with id " + id + " does not exist.");
    }

    public void getElementDescription(String id) throws Exception
    {
        List<Node> list =  baseMiddleNode.getValue();

        for (int i = 0; i < list.size(); i++)
        {
            Node node = list.get(i);

            if (!(node instanceof AttributeSupporter))
                throw new Exception("The element does not support ID.");

            if (!(((AttributeSupporter) node).getAttribute().getValue().equals(id)))
                continue;

            XMLConsoleTextPrinter xmlConsoleTextPrinter = new XMLConsoleTextPrinter();
            xmlConsoleTextPrinter.print(node);
            return;
        }

        throw new Exception("Element with id " + id + " does not exist.");
    }

    public void delete(String id, XML_ElementsTypes elementsTypes) throws Exception {

        List<Node> list =  baseMiddleNode.getValue();

        for (int i = 0; i < list.size(); i++)
        {
            Node node = list.get(i);

            if (!(node instanceof AttributeSupporter))
                throw new Exception("The element does not support ID.");

            if (!(((AttributeSupporter) node).getAttribute().getValue().equals(id)))
                continue;

            if (!(node instanceof BaseMiddleNode))
                throw new Exception("The element does not support key element.");

            BaseMiddleNode baseMiddleNodeChild = (BaseMiddleNode)node;

            for (Node chilsNode:
                    baseMiddleNodeChild.getValue())
            {
                if (chilsNode.getType().equals(elementsTypes))
                {
                    baseMiddleNodeChild.removeChild(chilsNode);
                    return;
                }
            }

            throw new Exception("Element with key " + elementsTypes + " is not supported.");
        }

        throw new Exception("Element with id " + id + " does not exist.");
    }


    public void addChild(String id, XML_ElementsTypes elementsTypes) throws Exception {
        if (!baseMiddleNode.supportChild(elementsTypes))
            throw new Exception(baseMiddleNode.getName() + " don't support " + elementsTypes.name());

        NodeIDFinder nodeIDFinder = new NodeIDFinder(baseMiddleNode.getValue());
        if (nodeIDFinder.hasId(id))
            throw new Exception("The ID is not unique.");


        Node node = XML_ElementsTypesFactory.createNode(elementsTypes);

        if (!(node instanceof AttributeSupporter))
            throw new Exception(elementsTypes + " do not support ID");

        ((AttributeSupporter) node).setAttribute(id);
        baseMiddleNode.addChild(node);

    }
}