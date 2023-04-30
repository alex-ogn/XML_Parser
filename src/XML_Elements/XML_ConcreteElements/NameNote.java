package XML_Elements.XML_ConcreteElements;
import XML_Elements.XML_BaseElements.BaseLeafNote;

public class NameNote extends BaseLeafNote<String> {
    public NameNote() {
        super("name");
    }

    public NameNote(String value) {
        super("name", value);
    }
}
