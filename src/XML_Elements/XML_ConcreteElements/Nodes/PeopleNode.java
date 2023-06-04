package XML_Elements.XML_ConcreteElements.Nodes;
import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_BaseElements.BaseMiddleNode;
import XML_Elements.XML_Interfaces.Node;
import java.util.ArrayList;
import java.util.List;

public class PeopleNode extends BaseMiddleNode {
    private List<PersonNode> personNodes;
    public PeopleNode() {
        super(XML_ElementsTypes.people);
        personNodes = new ArrayList<>();
    }

    @Override
    public void addChild(Node node) {
        if (node instanceof PersonNode)
            personNodes.add((PersonNode)node);
    }

    @Override
    public List<Node> getValue() {
        List<Node> nodes = new ArrayList<>(personNodes);
        return nodes;
    }

    @Override
    public void removeChild(Node node) {
        if (node instanceof PersonNode)
            personNodes.remove((PersonNode)node);
    }

    @Override
    public boolean supportChild(XML_ElementsTypes elementType)
    {
        boolean supportChild = false;
        switch (elementType)
        {
            case person:
            {
                supportChild = true;
                break;
            }
        }

        return supportChild;
    }
}
