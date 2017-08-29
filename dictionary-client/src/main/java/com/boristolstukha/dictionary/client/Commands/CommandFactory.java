package com.boristolstukha.dictionary.client.commands;

import com.boristolstukha.dictionary.client.UrlComponentsBuilderInitializer;
import org.springframework.web.util.UriComponentsBuilder;

public class CommandFactory {

    public static Command createCommand(String[] args) {
        if(args.length >= 3){
            switch (args[1]){
                case "get":
                    return new GetWordCommand(args[0], args[2]);
            }
        }
        return new HelpCommand();
    }

}
