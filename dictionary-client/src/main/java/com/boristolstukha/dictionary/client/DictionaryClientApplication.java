package com.boristolstukha.dictionary.client;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class DictionaryClientApplication {


    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();
        String schema = "http";
        String host = "localhost";
        int port = 8080;
        String path = "/dictionary/hello";
        try {
            URI uri = new URI(schema, null, host, port, path, null, null);
            DefinitionSetDTO definitionSetDTO = restTemplate.getForObject(uri, DefinitionSetDTO.class);
            System.out.println(definitionSetDTO.word);
            for(String value: definitionSetDTO.definitions){
                System.out.println(value);
            }
        }
        catch (URISyntaxException e){
            e.printStackTrace();
        }
    }
}
