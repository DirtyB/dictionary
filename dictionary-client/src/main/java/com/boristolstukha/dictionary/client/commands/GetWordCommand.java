package com.boristolstukha.dictionary.client.commands;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import org.springframework.web.client.RestTemplate;

public class GetWordCommand extends AbstractWordCommand {

    public GetWordCommand(String hostString, String word) {
        super(hostString, word);
    }

    @Override
    protected void performRequest(String uriString) {
        RestTemplate restTemplate = new RestTemplate();
        DefinitionSetDTO definitionSetDTO = restTemplate.getForObject(uriString, DefinitionSetDTO.class);
        for (String value : definitionSetDTO.definitions) {
            outputStream.println(value);
        }
    }

}
