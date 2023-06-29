package XML_Management;
import Utilities.ElementIdGenerator;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.Mapping.XML_ElementsTypesFactory;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;
import XML_Printers.TextFormatPrinter.XMLConsoleTextPrinter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XML_Manager
{
    private BaseMiddleNode baseMiddleNode;
    private ElementIdGenerator elementIdGenerator;
    public XML_Manager(BaseMiddleNode baseMiddleNode) {
        this.baseMiddleNode = baseMiddleNode;
        elementIdGenerator = new ElementIdGenerator(getIDMap(baseMiddleNode));
    }

    private Map<String, Integer> getIDMap(BaseMiddleNode baseMiddleNode)
    {
        Map<String, Integer> map = new HashMap<>();
        for (Node node:
                baseMiddleNode.getValue()) {

            if (!(node instanceof AttributeSupporter))
                continue;

            map.put(((AttributeSupporter) node).getAttribute().getValue(), 1);
        }

        return map;
    }
    public Node getNode(String id) throws Exception
    {
        List<Node> list =  baseMiddleNode.getValue();

        for (int i = 0; i < list.size(); i++)
        {
            Node node = list.get(i);

            if (!(node instanceof AttributeSupporter))
                throw new Exception("The element does not support ID.");

            if (!(((AttributeSupporter) node).getAttribute().getValue().equals(id)))
                continue;

            return node;
        }

        throw new Exception("Element with id " + id + " does not exist.");
    }
    public Node selectById(String id, XML_ElementsTypes elementsTypes) throws Exception
    {
        Node node = getNode(id);

        if (!(node instanceof BaseMiddleNode))
            throw new Exception("The element does not support key element.");

        BaseMiddleNode baseMiddleNodeChild = (BaseMiddleNode)node;

        for (Node childnode:
                baseMiddleNodeChild.getValue())
        {
            if (childnode.getType().equals(elementsTypes))
            {
                return childnode;
            }
        }

        throw new Exception("Element with key " + elementsTypes + " is not supported.");
    }
    public void getElementDescription(String id) throws Exception
    {
        Node node = getNode(id);

        XMLConsoleTextPrinter xmlConsoleTextPrinter = new XMLConsoleTextPrinter();
        xmlConsoleTextPrinter.print(node);
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
            if (baseMiddleNodeChild.getType().equals(elementsTypes))
            {
                baseMiddleNode.removeChild(baseMiddleNodeChild);
                return;
            }

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

        ((AttributeSupporter) node).setAttribute(elementIdGenerator.generateId(id));
        baseMiddleNode.addChild(node);
    }
    public Node getChild(String id, int number) throws Exception
    {
        List<Node> list =  baseMiddleNode.getValue();

        Node indexChild = null;

        for (int i = 0; i < list.size(); i++)
        {
            Node node = list.get(i);

            if (!(node instanceof AttributeSupporter))
                throw new Exception("The element does not support ID.");

            if (!(((AttributeSupporter) node).getAttribute().getValue().equals(id)))
                continue;

            if (!(node instanceof BaseMiddleNode))
                throw new Exception("The element does not support key element.");

            indexChild =  getChild(node, number, 0);
            if (indexChild == null)
                throw new Exception("Element does not exist.");
        }

        if (indexChild == null)
            throw new Exception("Element does not exist.");

        return indexChild;

    }

    private Node getChild(Node node, int number, int currentNumber) throws Exception
    {
        Node indexChild = null;

        if (number == currentNumber)
            return node;

        if (node instanceof BaseMiddleNode)
        {
            BaseMiddleNode baseMiddleNodeChild = (BaseMiddleNode)node;

            for (Node child:
                    baseMiddleNodeChild.getValue()) {
                indexChild =  getChild(child, number, currentNumber + 1);
                if (indexChild != null)
                    break;
            }
        }

        return indexChild;
    }
}
