package com.majestic.shoppingweb.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.majestic.shoppingweb.common.RestApi;
import com.majestic.shoppingweb.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class MainService {

    @Autowired
    private RestApi restApi;

    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public Map<String, Object> getLogin() throws Exception {


        MultiValueMap<String, Object> multiMap = new LinkedMultiValueMap<>();
        //multiMap.add("email", "3jwh@email.com");
        //multiMap.add("password", "1234");
        //multiMap.add("username", "3jwh@email.com");
        Map<String, Object> param = new HashMap<>();
        param.put("email", "3jwh@email.com");
        param.put("password", "1234");
        param.put("username", "3jwh@email.com");
        multiMap.add("memberRequestDto", param);

        String url = "/auth/login";

        // 버전 2
        //JSONObject param = new JSONObject();
        //param.put("email" ,multiMap.get("email").get(0) );
        //param.put("password" ,multiMap.get("password").get(0) );
        //param.put("username" ,multiMap.get("username").get(0) );

        // 버전3
        ObjectMapper objectMapper = new ObjectMapper();

        // 기존
        //Map<String, Object> map = restApi.api(multiMap, url);
        // 버전2
        //Map<String, Object> map = restApi.api2(param, url);
        // 버전3
        //Map<String, Object> map = restApi.api3(objectMapper.writeValueAsString(multiMap.get("memberRequestDto").get(0)), url);

        //버전4
        Map<String, Object> map = restApi.api4(param, url);


        // 메소드 만들기 RESTAPI
//        Map<String, String> params = new HashMap<>();
//        params.put("memberId", "11");
//        ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.POST, String.class, params);
//        log.info("response : {}", response);

        return map;
    }
}
