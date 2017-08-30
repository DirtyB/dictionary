package com.boristolstukha.dictionary.logic;

import java.util.Collection;
import java.util.Set;

public interface Dictionary {

    boolean add(String key, Collection<String> values);


    boolean delete(String key, Collection<String> values);

}
