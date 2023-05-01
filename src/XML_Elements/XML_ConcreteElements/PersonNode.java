package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;

public class PersonNode extends BaseMiddleNode {

    public PersonNode() {
        super(XML_ElementsTypes.person);
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
}
