package com.boristolstukha.dictionary.client;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryClientApplication {


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String host = (args.length > 0) ? args[0] : "localhost:8080";
        String word = (args.length > 1) ? args[1] : "hello";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://" + host);

        uriBuilder.replacePath("/dictionary");
        uriBuilder.pathSegment(word);

        String uriString = uriBuilder.toUriString();
        System.out.println(uriString);

        try {
            DefinitionSetDTO definitionSetDTO = restTemplate.getForObject(uriString, DefinitionSetDTO.class);
            System.out.println(definitionSetDTO.word);
            for (String value : definitionSetDTO.definitions) {
                System.out.println(value);
            }
        } catch (HttpClientErrorException exception) {
            String response = exception.getResponseBodyAsString();

            MapType type;

            type = TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, String> result = objectMapper.readValue(response, type);
                String message = result.get("message");
                if(message == null){
                    message = "Неизвестная ошибка";
                }
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
