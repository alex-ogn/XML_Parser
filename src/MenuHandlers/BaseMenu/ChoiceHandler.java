package MenuHandlers.BaseMenu;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;

public interface ChoiceHandler {
    void handleChoice(XML_ParserMenuItems menuItem) throws Exception;
}
