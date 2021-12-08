package com.majestic.shoppingweb.controller;

import com.majestic.shoppingweb.common.RestApi;
import com.majestic.shoppingweb.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        System.out.println("////////////////////");
        mav.setViewName("index");//view page name
        return mav;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() throws  Exception {
        log.info("login :::::::::::::::: ");

        ModelAndView mav = new ModelAndView();



        Map<String, Object> map = mainService.getLogin();




        mav.setViewName("index");//view page name
        return mav;
    }

}

