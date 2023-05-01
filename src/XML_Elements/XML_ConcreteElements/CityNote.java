package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseLeafNote;

public class CityNote extends BaseLeafNote<String> {
    public CityNote() {
        super(XML_ElementsTypes.city);
    }

    public CityNote(String value) {
        super(XML_ElementsTypes.city, value);
    }
}
