package MenuHandlers.XML_ParserMenuElements.CLI;
import MenuHandlers.BaseMenu.Menu;
import MenuHandlers.XML_ParserMenuElements.XML_ParserMenuItems;
import java.util.Scanner;

public class CLIMenu implements Menu {
    @Override
    public void executeChoice()
    {
        Scanner scanner = new Scanner(System.in);
        String input;

            while (true) {
            System.out.print("> ");
            input = scanner.nextLine();
            String[] command = input.split("\\s+");

            try
            {
                XML_ParserMenuItems menuItems = XML_ParserMenuItems.getItemByName(command[0]);
                CLIChoiceHandler choiceHandler = new CLIChoiceHandler(command);
                choiceHandler.handleChoice(menuItems);
            }
            catch (Exception e)
            {
                System.out.println("Error executing command: " + e.getMessage());
            }
        }
    }
}