package com.boristolstukha.dictionary.server.api.controller;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import com.boristolstukha.dictionary.logic.Dictionary;
import com.boristolstukha.dictionary.server.api.exceptions.NotFoundHttpException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private final Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public DefinitionSetDTO getDefinitions(@PathVariable("word") String word) throws NotFoundHttpException{
        Set<String> definitions = dictionary.get(word);
        if(definitions == null){
            throw new NotFoundHttpException("Слово отсутвует в словаре");
        }
        DefinitionSetDTO definitionSetDTO = new DefinitionSetDTO();
        definitionSetDTO.word = word;
        definitionSetDTO.definitions = definitions;
        return definitionSetDTO;
    }

}
