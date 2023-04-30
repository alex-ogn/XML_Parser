package MenuHandlers.XML_ParserMenuElements;
import MenuHandlers.BaseMenu.Menu;
import java.util.ArrayList;

public class XML_ParserMainMenuInitializer
{
    public static void Initialize()
    {
        ArrayList<XML_ParserMenuItems> menuItmens = new ArrayList<>();
        menuItmens.add(XML_ParserMenuItems.OPEN);
        menuItmens.add(XML_ParserMenuItems.SAVE_AS);
        menuItmens.add(XML_ParserMenuItems.CLOSE);
        menuItmens.add(XML_ParserMenuItems.SAVE);
        menuItmens.add(XML_ParserMenuItems.EXIT);
        menuItmens.add(XML_ParserMenuItems.HELP);

        Menu menu = new XML_ParserMenu(menuItmens);
        while (true)
        {
            try {
                // Runtime.getRuntime().exec("cls");
                menu.show();
                menu.executeChoice();
            }
            catch (Exception e)
            {

            }

        }
    }
}
