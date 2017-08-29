package com.boristolstukha.dictionary.client.Commands;

public class CommandFactory {

    public static Command createCommand(String[] args) {
        return new HelpCommand();
    }

}
