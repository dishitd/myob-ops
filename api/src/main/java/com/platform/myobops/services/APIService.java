package com.platform.myobops.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service @Log4j2
public class APIService {

    public String sendAPIData(){
        return "API Works!";
    }
}
