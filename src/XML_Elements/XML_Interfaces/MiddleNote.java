package XML_Elements.XML_Interfaces;

import java.util.List;

public interface MiddleNote extends Note<List<Note>>
{
    void addChild(Note note);
    boolean removeChild(Note note);
}
