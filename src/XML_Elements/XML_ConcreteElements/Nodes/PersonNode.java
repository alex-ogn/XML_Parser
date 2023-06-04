package XML_Elements.XML_ConcreteElements.Nodes;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_ConcreteElements.Attributes.IdAttribute;
import XML_Elements.XML_Interfaces.Attribute;
import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;

import java.util.ArrayList;
import java.util.List;

public class PersonNode extends BaseMiddleNode implements AttributeSupporter {
    private IdAttribute id;
    private NameNode name;
    private List<AddressNode> addressNodes;

    public PersonNode() {
        super(XML_ElementsTypes.person);
        id = new IdAttribute();
        addressNodes = new ArrayList<>();
    }

    public AddressNode GetAddresByIndex(int index)
    {
        return addressNodes.get(index);
    }

    @Override
    public void addChild(Node node) {
        if (node instanceof NameNode)
            name = (NameNode)node;
        else if(node instanceof AddressNode)
            addressNodes.add((AddressNode)node);
    }

    @Override
    public void removeChild(Node node) {
        if (node instanceof NameNode)
            name = null;
        else if(node instanceof AddressNode)
            addressNodes.remove(node);
    }

    @Override
    public List<Node> getValue() {
        List<Node> nodes = new ArrayList<>();

        if (name != null)
            nodes.add(name);

        for (AddressNode address
                :addressNodes
             ) {
            nodes.add(address);
        }

        return nodes;
    }

    public PersonNode(String id) {
        super(XML_ElementsTypes.person);
        this.id = new IdAttribute();
        this.id.setValue(id);
    }

    @Override
    public boolean supportChild(XML_ElementsTypes elementType)
    {
        boolean supportChild = false;

        switch (elementType)
        {
            case name:
            case address:
            {
                supportChild = true;
                break;
            }
        }

        return supportChild;
    }

    @Override
    public Attribute getAttribute() {
        return id;
    }

    @Override
    public void setAttribute(String id) {
        this.id.setValue(id);
    }
}
