package com.boristolstukha.dictionary.logic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An implementation of {@code dictionary} that may be used in concurrent environment
 * Concept taken from {@see https://stackoverflow.com/a/12200596}
 */
public class ConcurrentDictionary implements Dictionary{

    private Map<String, Set<String>> dictionaryMap = new ConcurrentHashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> get(String key) {
        Set<String> valueSet = dictionaryMap.get(key);
        if(valueSet == null || valueSet.isEmpty()){
            return Collections.emptySet();
        }
        return new HashSet<>(valueSet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(String key, Collection<String> values) {
        if(values == null){
            return false;
        }
        Set<String> curSet = dictionaryMap.get(key);
        while(true) {

            if((curSet != null) && curSet.containsAll(values)) {
                return false;
            }

            Set<String > newSet = new HashSet<>(values);

            if(curSet == null) {

                curSet = dictionaryMap.putIfAbsent(key, newSet);
                if(curSet == null) {
                    return true;
                }

            } else {

                newSet.addAll(curSet);
                if(dictionaryMap.replace(key, curSet, newSet)) {
                    return true;
                }
                curSet = dictionaryMap.get(key);

            }

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String key, Collection<String> values) {
        if(values == null){
            return false;
        }
        Set<String> curSet = dictionaryMap.get(key);
        while(true) {

            if((curSet == null) || Collections.disjoint(curSet, values))  {
                return false;
            }

            Set<String> newSet = new HashSet<>(curSet);
            newSet.removeAll(values);

            if(newSet.isEmpty()) {

                if(dictionaryMap.remove(key, curSet)) {
                    return true;
                }

            } else {

                if(dictionaryMap.replace(key, curSet, newSet)) {
                    return true;
                }

            }

            curSet = dictionaryMap.get(key);
        }
    }

}
