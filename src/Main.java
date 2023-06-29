import MenuHandlers.BaseMenu.Menu;
import MenuHandlers.XML_ParserMenuElements.CLI.CLIMenu;
import MenuHandlers.XML_ParserMenuElements.Menu.XML_ParserMainMenuInitializer;

public class Main {
    public static void main(String[] args) {
        Menu menu = new CLIMenu();
        menu.executeChoice();
    }
}