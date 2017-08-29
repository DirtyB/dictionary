package com.boristolstukha.dictionary.client.commands;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import org.springframework.web.client.RestTemplate;

public class AddWordCommand extends AbstractWordCommand {

    public AddWordCommand(String hostString, String word, String[] values) {
        super(hostString, word, values);
    }

    @Override
    protected void performRequest(String uriString) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uriString, values);
        outputStream.println("значения слова успешно добавлены");
    }

}
