package XML_Elements.XML_Interfaces;

import java.util.List;

public interface MiddleNode extends Node<List<Node>>
{
    void addChild(Node node);
    void removeChild(Node node);
}
