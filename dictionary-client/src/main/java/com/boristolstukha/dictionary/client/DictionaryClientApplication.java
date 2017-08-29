package com.boristolstukha.dictionary.client;

import com.boristolstukha.dictionary.client.commands.Command;
import com.boristolstukha.dictionary.client.commands.CommandFactory;

public class DictionaryClientApplication {


    public static void main(String[] args) {

        Command command = CommandFactory.createCommand(args);
        command.setOutputStream(System.out);
        try {
            command.run();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
