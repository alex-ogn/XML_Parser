package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;

public class AddressNode extends BaseMiddleNode {

    public AddressNode() {
        super(XML_ElementsTypes.address);
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

