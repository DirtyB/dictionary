package com.boristolstukha.dictionary.client.commands;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommandFactory {

    public static Command createCommand(String[] args) {
        if(args.length >= 3){

            String commandId = args[1];
            String host = args[0];
            String word = args[2];
            Set<String> values = new HashSet<>(Arrays.asList(Arrays.copyOfRange(args, 3, args.length)));

            if("get".equals(commandId) && values.isEmpty()){
                return new GetWordCommand(host, word);
            }
            else if(!values.isEmpty()) {
                switch (commandId) {
                    case "add":
                        return new AddWordCommand(host, word, values);
                    case "delete":
                        return new DeleteWordCommand(host, word, values);
                }
            }
        }

        return new HelpCommand();
    }

}
