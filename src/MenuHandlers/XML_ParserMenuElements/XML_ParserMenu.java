package MenuHandlers.XML_ParserMenuElements;
import MenuHandlers.BaseMenu.Menu;
import java.util.List;
import java.util.Scanner;

public class XML_ParserMenu implements Menu {
    private List<XML_ParserMenuItems> menuItems;
    public XML_ParserMenu(List<XML_ParserMenuItems> menuItems) {
        this.menuItems = menuItems;
    }
    @Override
    public void show() {
        System.out.println("Menu:");

        for (int i = 0; i < menuItems.size(); i++) {
            XML_ParserMenuItems menuItem = menuItems.get(i);
            System.out.println( i + ". " + menuItem.getName());
        }
    }
    @Override
    public void executeChoice()
    {
        Scanner input = new Scanner( System.in );

        int choiceNumber;
        do {
            System.out.println("Enter number: ");
            choiceNumber = input.nextInt();
        }
        while (choiceNumber < 0 || choiceNumber >= menuItems.size());

        XML_ParserMenuItems menuItem = menuItems.get(choiceNumber);
        onMenuItem(menuItem);
    }
    void onMenuItem(XML_ParserMenuItems menuItem)
    {
        XML_ParserMenuChoiceHandler choiceHandler = new XML_ParserMenuChoiceHandler();
        try {
            choiceHandler.handleChoice(menuItem);
        }
        catch (Exception e)
        {
            System.out.println("Error executing operation: " + e.getMessage());
        }

    }
}
