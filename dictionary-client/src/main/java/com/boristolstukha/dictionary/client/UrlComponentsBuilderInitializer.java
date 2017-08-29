package com.boristolstukha.dictionary.client;

import org.springframework.web.util.UriComponentsBuilder;

public class UrlComponentsBuilderInitializer {

    public static UriComponentsBuilder initUrlComponentsBuilder(String hostString){
        return UriComponentsBuilder.fromHttpUrl("http://" + hostString)
            .replacePath("/dictionary");
    }

}
