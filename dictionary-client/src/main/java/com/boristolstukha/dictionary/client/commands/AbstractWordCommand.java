package com.boristolstukha.dictionary.client.commands;

import org.springframework.web.util.UriComponentsBuilder;

public abstract class AbstractWordCommand extends AbstractCommand {

    protected String word;
    protected String uriString;

    AbstractWordCommand(UriComponentsBuilder uriComponentsBuilder, String word){
        this.word = word;
        uriString = uriComponentsBuilder.pathSegment(word).toUriString();
    }

}
