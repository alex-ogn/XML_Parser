package XML_Elements.XML_BaseElements;

import XML_Elements.Mapping.XML_ElementsTypes;
import XML_Elements.XML_Interfaces.MiddleNode;
import XML_Elements.XML_Interfaces.Node;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMiddleNode implements MiddleNode {
    private XML_ElementsTypes type;
    protected List<Node> childNodes;

    public BaseMiddleNode(XML_ElementsTypes type) {
        this.type = type;
        childNodes = new ArrayList<>();
    }

    @Override
    public String getName() {
        return type.name();
    }

    @Override
    public XML_ElementsTypes getType() {
        return type;
    }

    public abstract boolean supportChild(XML_ElementsTypes elementType);

    @Override
    public String toString() {
        return  "type = " + type +
                ", \nchildren: \n" + childNodes;
    }
}
