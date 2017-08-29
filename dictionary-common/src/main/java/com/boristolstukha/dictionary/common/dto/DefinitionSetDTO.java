package com.boristolstukha.dictionary.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DefinitionSetDTO {

    public String word;

    public Set<String> definitions;

}
