package MenuHandlers.XML_ParserMenuElements;

public enum XML_ParserMenuItems {
    //close closes currently opened file
    //save saves the currently open file
    //saveas <file> saves the currently open file in <file>
    //help prints this information
    //exit exists the program

    CLOSE("close"),
    SAVE("save"),
    SAVE_AS("save as"),
    HELP("help"),
    EXIT("exit"),
    TO_MAIN_MENU("back to main menu");
    private final String name;
    private XML_ParserMenuItems(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
