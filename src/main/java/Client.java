public class Client {

    private InputHandler inputHandler;
    private PrintHandler printHandler;

    public Client() {
        inputHandler = new InputHandler();
        printHandler = new PrintHandler();
    }

    protected void runApplication() {
        printHandler.printToTerminal(inputHandler.startMenu());
        inputHandler.startMenuChoice(inputHandler.getUserFeedInput());
    }
}
