package app.services;

import app.exceptions.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONtoWrapperConverter<T> {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T>T JSONtoWrapper(String json, Class<T> tClass){
        try {
            return objectMapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new ApiException(500, e.getMessage());
        }
    }
}
