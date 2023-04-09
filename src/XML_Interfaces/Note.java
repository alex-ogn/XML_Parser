package XML_Interfaces;

import java.util.List;

public interface Note<T> {
    String getName();
    T getValue();
    void setValue(T value);

}
