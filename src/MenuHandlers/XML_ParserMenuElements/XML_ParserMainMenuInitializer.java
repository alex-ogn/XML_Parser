package MenuHandlers.XML_ParserMenuElements;
import MenuHandlers.BaseMenu.Menu;
import java.util.ArrayList;

public class XML_ParserMainMenuInitializer extends XML_ParserMenuInitializer
{

    public XML_ParserMainMenuInitializer() {
        super(false);
    }

    @Override
    protected void setMenuItmens(ArrayList<XML_ParserMenuItems> menuItmens) {
        menuItmens.add(XML_ParserMenuItems.FILE_OPERATIONS);
        menuItmens.add(XML_ParserMenuItems.XML_OPERATIONS);
        menuItmens.add(XML_ParserMenuItems.HELP);
        menuItmens.add(XML_ParserMenuItems.EXIT);
    }
}
