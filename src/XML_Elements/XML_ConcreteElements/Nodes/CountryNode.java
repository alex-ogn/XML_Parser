package XML_Elements.XML_ConcreteElements.Nodes;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseLeafNode;

public class CountryNode extends BaseLeafNode<String> {
    public CountryNode() {
        super(XML_ElementsTypes.country);
    }

    public CountryNode(String value) {
        super(XML_ElementsTypes.country, value);
    }

    @Override
    public void setStringValue(String value) {
        this.value = value;
    }
}
