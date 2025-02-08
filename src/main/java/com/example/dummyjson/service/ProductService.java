package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

   @Autowired
    private WebClient webClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Product> getAllProducts() {
        Map<String, Object> response = webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();

        if (response == null || !response.containsKey("products")) {
            return List.of();
        }

        return ((List<?>) response.get("products")).stream()
                .map(obj -> objectMapper.convertValue(obj, Product.class))
                .toList();
    }

    public Product getProductById(Long id) {
        String url = "/" + id;

        try {
            return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(Product.class)
                    .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            }
            throw e;
        }
    }

}
