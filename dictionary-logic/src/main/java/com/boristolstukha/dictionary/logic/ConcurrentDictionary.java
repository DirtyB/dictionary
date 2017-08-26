package com.boristolstukha.dictionary.logic;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentDictionary implements Dictionary{

    private Map<String, Set<String>> dictionaryMap = new ConcurrentHashMap<>();

    @Override
    public boolean add(String key, String value) {
        List<String> list = new ArrayList<>(1);
        list.add(value);
        return add(key, list);
    }

    @Override
    public boolean add(String key, Collection<String> values) {
        Set<String> valueSet = getOrCreateValueSet(key);
        synchronized (valueSet) {
            return valueSet.addAll(values);
        }
    }

    @Override
    public Set<String> get(String key) {
        Set<String> valueSet = dictionaryMap.get(key);
        if(valueSet == null || valueSet.isEmpty()){
            return null;
        }
        return new HashSet<>(valueSet);
    }

    @Override
    public boolean delete(String key, String value) {
        List<String> list = new ArrayList<>(1);
        list.add(value);
        return delete(key, list);
    }

    @Override
    public boolean delete(String key, Collection<String> values) {
        Set<String> valueSet = dictionaryMap.get(key);
        if(valueSet == null){
            return false;
        }
        synchronized (valueSet) {
            return valueSet.removeAll(values);
        }
    }

    private Set<String> getOrCreateValueSet(String key){
        if(key == null){
            throw new NullPointerException();
        }
        return dictionaryMap.computeIfAbsent(key, (String _key)-> Collections.newSetFromMap(new ConcurrentHashMap<>()));
    }

}
