package XML_Elements.XML_ConcreteElements.Nodes;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_ConcreteElements.Attributes.IdAttribute;
import XML_Elements.XML_Interfaces.Attribute;
import XML_Elements.XML_Interfaces.AttributeSupporter;

public class PersonNode extends BaseMiddleNode implements AttributeSupporter {
    private IdAttribute id;

    public PersonNode() {
        super(XML_ElementsTypes.person);
        id = new IdAttribute();
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
