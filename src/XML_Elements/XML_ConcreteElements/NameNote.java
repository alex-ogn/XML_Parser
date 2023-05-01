package XML_Elements.XML_ConcreteElements;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseLeafNote;

public class NameNote extends BaseLeafNote<String> {
    public NameNote() {
        super(XML_ElementsTypes.name);
    }

    public NameNote(String value) {
        super(XML_ElementsTypes.name, value);
    }
}
