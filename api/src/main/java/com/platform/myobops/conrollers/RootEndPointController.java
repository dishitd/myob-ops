package com.platform.myobops.conrollers;

import com.platform.myobops.services.APIService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
@CrossOrigin(origins = "*")
public class RootEndPointController {


    @Autowired
    APIService apiService;

    @GetMapping("/api/getresult")
    public ResponseEntity<String> getResult() {

        log.info("API Call Started");
        String responseString = apiService.sendAPIData();
        log.info("API Call Processed");

        return ResponseEntity.ok()
                .cacheControl(CacheControl.noCache())
                .body(responseString);
    }

}
