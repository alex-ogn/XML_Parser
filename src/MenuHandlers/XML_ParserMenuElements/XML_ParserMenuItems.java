package MenuHandlers.XML_ParserMenuElements;

public enum XML_ParserMenuItems {
    OPEN("open", "opens file"),
    CLOSE("close", "closes currently opened file"),
    SAVE("save", "saves the currently open file"),
    SAVE_AS("save as", "saves the currently open file in new file"),
    HELP("help", "prints this information"),
    EXIT("exit", "exists the program"),
    TO_MAIN_MENU("main menu", "return to the main menu"),
    FILE_OPERATIONS("file operations", "show menu for file operations"),
    XML_OPERATIONS("xml operations", "show menu for xml operations"),
    PRINT_XML("print xml", "prints xml"),
    SELECT_XML("select <id> <key>", "Returns an attribute value by a given element ID and attribute key"),
    SET_XML("set <id> <key> <value>", "Assigning a value to an attribute"),
    LIST_CHILDREN_XML("children <id>", "List of nested element attributes"),
    CHILDREN_DESCENDANT_XML("children <id> <n>", "Access the N descendant of an element"),
    TEXT_XML("text", "Access the text of an element"),
    DELETE_XML("delete", "Delete element attribute by key"),
    NEW_CHILD_XML("new child", "Adding a NEW element successor. The new item does not no attributes except id"),
    XPATH_XML("xpath", "Operations to perform simple XPath 2.0 queries to a given element that returns a list of XML elements");

    private final String name;
    private final String description;

    private XML_ParserMenuItems(String name) {
        this.name = name;
        this.description = "";
    }
    private XML_ParserMenuItems(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
