package XML_Elements.XML_ConcreteElements.Nodes;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.Node;

import java.util.ArrayList;
import java.util.List;

public class AddressNode extends BaseMiddleNode {

    private CityNode cityNode;
    private CountryNode countryNode;

    public AddressNode() {
        super(XML_ElementsTypes.address);
    }

    @Override
    public void addChild(Node node) {
        if (node instanceof CityNode)
            cityNode = (CityNode) node;
        else if(node instanceof CountryNode)
            countryNode = (CountryNode) node;
    }

    @Override
    public void removeChild(Node node) {
        if (node instanceof CityNode)
            cityNode = null;
        else if(node instanceof CountryNode)
            countryNode = null;
    }

    @Override
    public List<Node> getValue() {
        List<Node> nodes = new ArrayList<>();

        if (cityNode != null)
            nodes.add(cityNode);

        if (countryNode != null)
            nodes.add(countryNode);

        return nodes;
    }

    @Override
    public boolean supportChild(XML_ElementsTypes elementType)
    {
        boolean supportChild = false;
        switch (elementType)
        {
            case city:
            case country:
            {
                supportChild = true;
                break;
            }
        }

        return supportChild;
    }

}

