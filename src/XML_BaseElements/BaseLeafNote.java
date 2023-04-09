package XML_BaseElements;
import XML_Interfaces.Note;


public abstract class BaseLeafNote<T> implements Note<T> {
    private String name;
    private T value;

    public BaseLeafNote(String name) {
        this.name = name;
    }
    public BaseLeafNote(String name, T value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }
}
