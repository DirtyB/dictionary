package com.boristolstukha.dictionary.client.commands;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

public class DeleteWordCommand extends AbstractWordCommand {

    public DeleteWordCommand(String hostString, String word, Set<String> values) {
        super(hostString, word, values);
    }

    @Override
    protected void performRequest(String uriString) {
        //todo проверить что values не пусто
        CustomRestTemplate restTemplate = new CustomRestTemplate();
        restTemplate.deleteWithBody(uriString, values);
        outputStream.println("значения слова успешно удалены");
    }

    private class CustomRestTemplate extends RestTemplate{
        public void deleteWithBody(String url, Object request, Object... uriVariables) throws RestClientException {
            RequestCallback requestCallback = this.httpEntityCallback(request);
            this.execute(url, HttpMethod.DELETE, requestCallback, (ResponseExtractor)null, (Object[])uriVariables);
        }
    }

}
