package XML_FIleManagers;

import XML_Elements.XML_ConcreteElements.Nodes.PeopleNode;

public class PeopleXML_FileManager extends XML_FileManager<PeopleNode>
{
    private static PeopleXML_FileManager fileManager;

    private PeopleXML_FileManager(PeopleNode startNode) {
        super(startNode);
    }

    public static PeopleXML_FileManager getInstance()
    {
        if (fileManager == null)
            fileManager = new PeopleXML_FileManager(new PeopleNode());

        return fileManager;
    }

    @Override
    protected PeopleNode getNewStartNode() {
        return new PeopleNode();
    }
}
