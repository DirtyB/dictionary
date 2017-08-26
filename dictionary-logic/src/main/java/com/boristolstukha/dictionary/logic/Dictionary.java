package com.boristolstukha.dictionary.logic;

import java.util.Collection;
import java.util.Set;

public interface Dictionary {

    boolean add(String key, String value);
    boolean add(String key, Collection<String> values);

    Set<String> get(String key);

    boolean delete(String key, String value);
    boolean delete(String key, Collection<String> values);

}
