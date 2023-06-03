package XML_Elements.XML_Interfaces;

import XML_Elements.Mapping.XML_ElementsTypes;

public interface Node<T> {
    String getName();
    T getValue();
    void setValue(T value);
    XML_ElementsTypes getType();
}
