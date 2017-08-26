package com.boristolstukha.dictionary.server;

import com.boristolstukha.dictionary.logic.ConcurrentDictionary;
import com.boristolstukha.dictionary.logic.Dictionary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DictionaryServerApplication {

	@Bean
	public Dictionary dictionary(){
		Dictionary dictionary = new ConcurrentDictionary();
		List<String> helloDefinitions = new ArrayList<>();
		helloDefinitions.add("здравствуйте");
		helloDefinitions.add("привет");
		dictionary.add("hello", helloDefinitions);
		return dictionary;
	}

	public static void main(String[] args) {
		SpringApplication.run(DictionaryServerApplication.class, args);
	}
}
