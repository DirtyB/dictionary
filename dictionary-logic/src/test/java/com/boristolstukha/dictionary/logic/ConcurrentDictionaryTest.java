package com.boristolstukha.dictionary.logic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class ConcurrentDictionaryTest {

    @Test
    public void dictionaryAddGetTest(){
        Dictionary dictionary = new ConcurrentDictionary();

        List<String> meanings = new ArrayList<String>();
        meanings.add("привет");
        meanings.add("алло");
        meanings.add("здравствуйте");

        assertTrue(dictionary.add("hello", "здравствуйте"));
        assertTrue(dictionary.add("goodbye", "до свидания"));
        assertTrue(dictionary.add("hello", meanings));
        assertFalse(dictionary.add("hello", "алло"));
        assertFalse(dictionary.add("hello", meanings));

        Set<String> actual = dictionary.get("hello");

        assertEquals(3,actual.size());
        for(String value: meanings){
            assertTrue(actual.contains(value));
        }

    }

}
