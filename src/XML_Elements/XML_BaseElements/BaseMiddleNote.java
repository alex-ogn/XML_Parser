package XML_Elements.XML_BaseElements;

import XML_Elements.XML_Interfaces.MiddleNote;
import XML_Elements.XML_Interfaces.Note;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMiddleNote implements MiddleNote {
    private String name;
    List<Note> childNotes;

    public BaseMiddleNote(String name) {
        this.name = name;
        childNotes = new ArrayList<>();
    }

    @Override
    public void addChild(Note note) {
        childNotes.add(note);
    }

    @Override
    public boolean removeChild(Note note) {
        return childNotes.remove(note);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Note> getValue() {
        return childNotes;
    }

    @Override
    public void setValue(List<Note> value) {
        childNotes = value;
    }
}
