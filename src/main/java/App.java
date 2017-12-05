import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
//        Client client = new Client();
//        client.runApplication();
//        GUIHandler guiHandler = new GUIHandler();
//        guiHandler.setUpGUI();
        JSONHandler jsonHandler = new JSONHandler();
        System.out.println(jsonHandler.parseDinnersFile());
    }
}
