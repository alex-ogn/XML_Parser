package XML_Elements.Mapping;

import XML_Elements.XML_ConcreteElements.*;
import XML_Elements.XML_Interfaces.Node;

public class XML_ElementsTypesFactory {
    public static Node createNode(XML_ElementsTypes elementType) throws IllegalArgumentException
    {
        if (elementType == null)
            throw new IllegalArgumentException("Invalid node");

        switch (elementType)
        {
            case city:
                return new CityNode();
            case country:
                return new CountryNode();
            case name:
                return new NameNode();
            case address:
                return new AddressNode();
            case person:
                return new PersonNode();
            case people:
                return new PeopleNode();
            default:
                throw new IllegalArgumentException("Unknown node");
        }

    }
}
