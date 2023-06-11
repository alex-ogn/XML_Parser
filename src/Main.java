
import MenuHandlers.XML_ParserMenuElements.XML_ParserMainMenuInitializer;
import XML_FIleManagers.PeopleXML_FileManager;

public class Main {
    public static void main(String[] args) {
        //todo delete
        try {
            PeopleXML_FileManager fileManager = PeopleXML_FileManager.getInstance();
            fileManager.openFile("C:\\Users\\Alex\\Desktop\\Уни\\2 година\\2 Семестър\\ООП\\KP\\XML Parser\\text.xml");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        XML_ParserMainMenuInitializer menuInitializer = new XML_ParserMainMenuInitializer();
        menuInitializer.Initialize();
    }
}