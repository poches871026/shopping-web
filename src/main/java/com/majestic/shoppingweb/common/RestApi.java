package com.majestic.shoppingweb.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RestApi {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.server.url}")
    private String apiServerUrl;

    public Map<String, Object> api(MultiValueMap<String, Object> map, String url) throws Exception {

        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);


        log.info("url :::::: " + apiServerUrl + url);
        URI targetUri = UriComponentsBuilder.fromHttpUrl(apiServerUrl + url).build().toUri();

        log.info("targetUri :::::: " + targetUri);
        JSONObject param = new JSONObject();

        param.put("email", map.get("email").get(0));
        param.put("password", map.get("password").get(0));
        param.put("username", map.get("username").get(0));

        // 기존
        // HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map,httpHeaders);

        HttpEntity<?> request = new HttpEntity<>(param, httpHeaders);


        // 기존
        // ResponseEntity<String> resultStr = restTemplate.exchange(targetUri, HttpMethod.POST, request, String.class);

        ResponseEntity<JSONObject> resultStr = restTemplate.exchange(targetUri, HttpMethod.POST, request, JSONObject.class);

        log.info("resultStr :::::: " + resultStr);

        Map<String, Object> result = new HashMap<>();

        return result;

    }

    public Map<String, Object> api2(JSONObject param, String url) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        log.info("url 2222222222 :::::: " + apiServerUrl + url);
        URI targetUri = UriComponentsBuilder.fromHttpUrl(apiServerUrl + url).build().toUri();

        log.info("param 2222222222 :::::: " + param);

        HttpEntity<?> request = new HttpEntity<>(param, httpHeaders);

        ResponseEntity<JSONObject> resultStr = restTemplate.exchange(targetUri, HttpMethod.POST, request, JSONObject.class);

        log.info("resultStr 2222222  :::::: " + resultStr);

        Map<String, Object> result = new HashMap<>();

        return result;
    }

    public Map<String, Object> api3(String writeValueAsString, String url) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        URI targetUri = UriComponentsBuilder.fromHttpUrl(apiServerUrl + url).build().toUri();

        HttpEntity<String> request = new HttpEntity<>(writeValueAsString, httpHeaders);
        log.info("request 33333  :::::: " + request);

        ResponseEntity<String> resultStr = restTemplate.exchange(targetUri, HttpMethod.POST, request, String.class);

        log.info("resultStr 33333  :::::: " + resultStr);
        Map<String, Object> result = new HashMap<>();

        return result;

    }

    public Map<String, Object> api4(Map<String, Object> param, String url) {

        HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        log.info("url 44444444444 :::::: " + apiServerUrl + url);
        URI targetUri = UriComponentsBuilder.fromHttpUrl(apiServerUrl + url).build().toUri();

        log.info("param 444444444 :::::: " + param);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(param, httpHeaders);

        ResponseEntity<String> resultStr = restTemplate.exchange(targetUri, HttpMethod.POST, request, String.class);

        log.info("resultStr 444444444  :::::: " + resultStr);

        Map<String, Object> result = new HashMap<>();

        return result;
    }
}
