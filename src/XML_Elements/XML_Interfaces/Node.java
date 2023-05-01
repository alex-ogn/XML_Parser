package XML_Elements.XML_Interfaces;

public interface Node<T> {
    String getName();
    T getValue();
    void setValue(T value);

}
