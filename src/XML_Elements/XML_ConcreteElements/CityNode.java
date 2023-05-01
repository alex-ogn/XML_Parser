package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseLeafNode;

public class CityNode extends BaseLeafNode<String> {
    public CityNode() {
        super(XML_ElementsTypes.city);
    }

    public CityNode(String value) {
        super(XML_ElementsTypes.city, value);
    }
}
