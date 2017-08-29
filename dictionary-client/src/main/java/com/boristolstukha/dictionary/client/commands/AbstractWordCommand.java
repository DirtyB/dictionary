package com.boristolstukha.dictionary.client.commands;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWordCommand extends AbstractCommand {

    protected String word;
    protected String hostString;

    AbstractWordCommand(String hostString, String word){
        this.word = word;
        this.hostString = hostString;
    }

    @Override
    public void run() throws Exception {
        String uriString = UriComponentsBuilder.fromHttpUrl("http://" + hostString)
                .replacePath("/dictionary")
                .pathSegment(word)
                .toUriString();
        try {
            performRequest(uriString);
        } catch (HttpClientErrorException exception) {
            String response = exception.getResponseBodyAsString();

            MapType type;

            type = TypeFactory.defaultInstance().constructMapType(HashMap.class, String.class, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            String message = null;
            try {
                Map<String, String> result = objectMapper.readValue(response, type);
                message = result.get("message");

            } catch (IOException e) {
                //todo: log error
            }
            if(message == null){
                message = "Неизвестная ошибка";
            }
            outputStream.println(message);
        }
        catch (ResourceAccessException exception){
            //todo: log error
            outputStream.println("Не удалось соединиться с сервером");
        }
    }

    protected abstract void performRequest(String uriString);
}
