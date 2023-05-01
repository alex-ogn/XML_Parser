package XML_Elements.XML_ConcreteElements;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseLeafNode;

public class NameNode extends BaseLeafNode<String> {
    public NameNode() {
        super(XML_ElementsTypes.name);
    }

    public NameNode(String value) {
        super(XML_ElementsTypes.name, value);
    }

    @Override
    public void setStringValue(String value) {
        setValue(value);
    }
}
