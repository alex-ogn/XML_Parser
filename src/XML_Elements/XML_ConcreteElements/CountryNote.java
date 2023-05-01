package XML_Elements.XML_ConcreteElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseLeafNote;

public class CountryNote extends BaseLeafNote<String> {
    public CountryNote() {
        super(XML_ElementsTypes.country);
    }

    public CountryNote(String value) {
        super(XML_ElementsTypes.country, value);
    }
}
