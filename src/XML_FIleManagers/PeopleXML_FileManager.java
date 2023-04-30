package XML_FIleManagers;

import XML_Elements.XML_ConcreteElements.PeopleNote;

public class PeopleXML_FileManager extends XML_FileManager<PeopleNote>
{
    private static PeopleXML_FileManager fileManager;

    private PeopleXML_FileManager(PeopleNote startNote) {
        super(startNote);
    }

    public static PeopleXML_FileManager getInstance()
    {
        if (fileManager == null)
            fileManager = new PeopleXML_FileManager(new PeopleNote());

        return fileManager;
    }

    @Override
    protected PeopleNote getNewStartNote() {
        return new PeopleNote();
    }
}
