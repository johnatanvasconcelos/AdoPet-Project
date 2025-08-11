package br.com.javapet.api;

public class CommandExecutor {

    public void executeCommand(Command command){
        command.execute();
    }
}
