package MenuHandlers.XML_ParserMenuElements;

import java.util.ArrayList;

public class XML_ParserXMLOperationsMenuInitializer extends XML_ParserMenuInitializer
{

    public XML_ParserXMLOperationsMenuInitializer() {
        super(true);
    }

    @Override
    protected void setMenuItmens(ArrayList<XML_ParserMenuItems> menuItmens) {
        menuItmens.add(XML_ParserMenuItems.PRINT_XML);
        menuItmens.add(XML_ParserMenuItems.SELECT_XML);
        menuItmens.add(XML_ParserMenuItems.SET_XML);
        menuItmens.add(XML_ParserMenuItems.LIST_CHILDREN_XML);
        menuItmens.add(XML_ParserMenuItems.CHILDREN_DESCENDANT_XML);
        menuItmens.add(XML_ParserMenuItems.TEXT_XML);
        menuItmens.add(XML_ParserMenuItems.DELETE_XML);
        menuItmens.add(XML_ParserMenuItems.NEW_CHILD_XML);
        menuItmens.add(XML_ParserMenuItems.XPATH_XML);
        menuItmens.add(XML_ParserMenuItems.TO_MAIN_MENU);
    }
}