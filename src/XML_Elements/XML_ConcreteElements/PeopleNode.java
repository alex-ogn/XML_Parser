package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;

public class PeopleNode extends BaseMiddleNode {

    public PeopleNode() {
        super(XML_ElementsTypes.people);
    }

    @Override
    public boolean supportChild(XML_ElementsTypes elementType)
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
