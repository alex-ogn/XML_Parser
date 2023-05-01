package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNote;

public class AddressNote extends BaseMiddleNote {

    public AddressNote() {
        super(XML_ElementsTypes.address);
    }

    @Override
    public boolean SupportChild(XML_ElementsTypes elementType)
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

