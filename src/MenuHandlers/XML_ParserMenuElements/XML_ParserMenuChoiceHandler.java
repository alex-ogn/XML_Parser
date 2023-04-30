package MenuHandlers.XML_ParserMenuElements;

public class XML_ParserMenuChoiceHandler
{
    public void HandleChoice(XML_ParserMenuItems menuItem)
    {
        switch (menuItem)
        {
            case CLOSE:
            {
                System.out.println(menuItem.getName());
                break;
            }
            case SAVE:
            {
                System.out.println(menuItem.getName());
                break;
            }
            case SAVE_AS:
            {
                System.out.println(menuItem.getName());
                break;
            }
            case HELP:
            {
                System.out.println(menuItem.getName());
                break;
            }
            case EXIT:
            {
                OnExit();
                break;
            }
            case TO_MAIN_MENU:
            {
                System.out.println(menuItem.getName());
                break;
            }
            default:
            {
                break;
            }
        }
    }

    private void OnExit()
    {
        System.exit(0);
    }
}
