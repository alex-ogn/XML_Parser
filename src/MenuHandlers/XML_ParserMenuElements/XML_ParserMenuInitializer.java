package MenuHandlers.XML_ParserMenuElements;

import MenuHandlers.BaseMenu.Menu;
import java.util.ArrayList;

public abstract class XML_ParserMenuInitializer {

    private boolean isTemporary;

    public XML_ParserMenuInitializer(boolean isTemporary)
    {
        this.isTemporary = isTemporary;
    }

    ArrayList<XML_ParserMenuItems> menuItmens = new ArrayList<>();

    protected abstract void setMenuItmens(ArrayList<XML_ParserMenuItems> menuItmens);

    public void Initialize()
    {
        setMenuItmens(menuItmens);
        Menu menu = new XML_ParserMenu(menuItmens);
       do
        {
            try {
                menu.show();
                menu.executeChoice();
            }
            catch (Exception e)
            {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }
       while (!isTemporary);
    }
}
