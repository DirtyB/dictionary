package com.boristolstukha.dictionary.client.commands;

import java.util.Arrays;

public class CommandFactory {

    public static Command createCommand(String[] args) {
        if(args.length >= 3){
            String commandId = args[1];
            String host = args[0];
            String word = args[2];
            String[] values =  Arrays.copyOfRange(args, 3, args.length);
            switch (commandId){
                case "get":
                    return new GetWordCommand(host, word);
                case "add":
                    return new AddWordCommand(host, word, values);
            }
        }
        return new HelpCommand();
    }

}
