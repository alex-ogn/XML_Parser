package XML_Elements.XML_BaseElements;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_Interfaces.Note;


public abstract class BaseLeafNote<T> implements Note<T> {
    private XML_ElementsTypes type;
    private T value;

    public BaseLeafNote(XML_ElementsTypes type) {
        this.type = type;
    }
    public BaseLeafNote(XML_ElementsTypes type, T value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String getName() {
        return type.name();
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
