package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNote;

public class PeopleNote extends BaseMiddleNote {

    public PeopleNote() {
        super(XML_ElementsTypes.people);
    }

    @Override
    public boolean SupportChild(XML_ElementsTypes elementType)
    {
        boolean supportChild = false;
        switch (elementType)
        {
            case person:
            {
                supportChild = true;
                break;
            }
        }

        return supportChild;
    }
}
