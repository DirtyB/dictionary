package com.boristolstukha.dictionary.logic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Represent dictionary where a word may have multiple definitions
 */

public interface Dictionary {

    /**
     * Returns the set of definition for the word {@code key}.
     * If no definitions are in dictionary, returns empty set
     *
     * @param key the word to search for
     * @return set of definitions
     */
    Set<String> get(String key);

    /**
     * Adds all definitions in {@code values} for word {@code key}.
     *
     * @param key the word to set definitions for
     * @param values set of new definitions
     * @return whether any new definition was added
     */
    boolean add(String key, Collection<String> values);

    /**
     * Adds definition {@code value} for word {@code key}.
     *
     * @param key the word to set definitions for
     * @param value new definition
     * @return whether any new definition was added
     */
    default boolean add(String key, String value){
        return add(key, Arrays.asList(value));
    }

    /**
     * Removes all definitions in {@code values} for word {@code key}.
     *
     * @param key the word to remove definitions for
     * @param values set of definitions to remove
     * @return whether any definition was removed
     */
    boolean delete(String key, Collection<String> values);

    /**
     * Removes definitions {@code value} for word {@code key}.
     *
     * @param key the word to remove definitions for
     * @param value definition to remove
     * @return whether definition was removed
     */
    default boolean delete(String key, String value){
        return delete(key, Arrays.asList(value));
    }


}
