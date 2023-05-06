package XML_Elements.XML_ConcreteElements.Attributes;

import XML_Elements.XML_Interfaces.Attribute;

public class IdAttribute implements Attribute
{
    private String value;

    public IdAttribute() { }

    public IdAttribute(String value)
    {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return "Id";
    }
}
