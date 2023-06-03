package XML_Management;

import XML_Elements.XML_Interfaces.AttributeSupporter;
import XML_Elements.XML_Interfaces.Node;
import java.util.List;

public class NodeIDFinder {

    List<Node> nodes;

    NodeIDFinder(List<Node> nodes)
    {
        this.nodes = nodes;
    }

    public boolean hasId(String id)
    {
        for (Node node:
                nodes)
        {
            if (!(node instanceof AttributeSupporter))
                continue;

            if ((((AttributeSupporter) node).getAttribute().equals(id)))
                return true;
        }

        return false;
    }

}
