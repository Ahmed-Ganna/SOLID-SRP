package hr.logging;

public class ConsoleLogger {

    public void writeMessage(String message){
        System.out.println(message);
    }

    public void writeError(String message , Exception e){
        System.err.println(message+" ; "+ e.getMessage());
    }
}
