package MenuHandlers.XML_ParserMenuElements;

public enum XML_ParserMenuItems {
    OPEN("close", "opens file"),
    CLOSE("close", "closes currently opened file"),
    SAVE("save", "saves the currently open file"),
    SAVE_AS("save as", "saves the currently open file in new file"),
    HELP("help", "prints this information"),
    EXIT("exit", "exists the program"),
    TO_MAIN_MENU("main menu", "return to the main menu");
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
