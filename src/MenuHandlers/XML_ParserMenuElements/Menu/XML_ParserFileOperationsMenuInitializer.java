package MenuHandlers.XML_ParserMenuElements.Menu;

import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;

import java.util.ArrayList;

public class XML_ParserFileOperationsMenuInitializer extends XML_ParserMenuInitializer
{

    public XML_ParserFileOperationsMenuInitializer() {
        super(true);
    }

    @Override
    protected void setMenuItmens(ArrayList<XML_ParserMenuItems> menuItmens) {
        menuItmens.add(XML_ParserMenuItems.OPEN);
        menuItmens.add(XML_ParserMenuItems.CLOSE);
        menuItmens.add(XML_ParserMenuItems.SAVE);
        menuItmens.add(XML_ParserMenuItems.SAVE_AS);
        menuItmens.add(XML_ParserMenuItems.TO_MAIN_MENU);
    }
}