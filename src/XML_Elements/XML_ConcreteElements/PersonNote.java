package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNote;

public class PersonNote extends BaseMiddleNote {

    public PersonNote() {
        super(XML_ElementsTypes.person);
    }

    @Override
    public boolean SupportChild(XML_ElementsTypes elementType)
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
