package com.boristolstukha.dictionary.server.api.controller;

import com.boristolstukha.dictionary.common.dto.DefinitionSetDTO;
import com.boristolstukha.dictionary.logic.Dictionary;
import com.boristolstukha.dictionary.server.api.exception.NotFoundHttpException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    private static final String WORD_NOT_FOUND = "Слово отсутвует в словаре";
    private static final String WORD_OR_DEFINITION_NOT_FOUND = "Слово либо значение отсутвует в словаре";

    private final Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @RequestMapping(value = "/{word}", method = RequestMethod.GET)
    public DefinitionSetDTO getDefinitions(@PathVariable("word") String word) throws NotFoundHttpException {
        Set<String> definitions = dictionary.get(word);
        if(definitions.isEmpty()){
            throw new NotFoundHttpException(WORD_NOT_FOUND);
        }
        DefinitionSetDTO definitionSetDTO = new DefinitionSetDTO();
        definitionSetDTO.word = word;
        definitionSetDTO.definitions = definitions;
        return definitionSetDTO;
    }

    @RequestMapping(value = "/{word}", method = { RequestMethod.POST, RequestMethod.PUT })
    public void postDefinitions(@PathVariable("word") String word,
                                @RequestBody List<String> definitions){
        dictionary.add(word, definitions);
    }

    @RequestMapping(value = "/{word}", method = { RequestMethod.DELETE })
    public void deleteDefinitions(@PathVariable("word") String word,
                                @RequestBody List<String> definitions) throws NotFoundHttpException {
        if(!dictionary.delete(word, definitions)){
            throw new NotFoundHttpException(WORD_OR_DEFINITION_NOT_FOUND);
        }
    }

}
