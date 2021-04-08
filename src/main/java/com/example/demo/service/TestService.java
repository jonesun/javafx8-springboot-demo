package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jone.sun
 * @date 2021/2/24 15:37
 */
@Service
public class TestService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String sayHello() {
        return "hello";
    }

}
