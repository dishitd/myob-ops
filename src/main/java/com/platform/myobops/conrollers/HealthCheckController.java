package com.platform.myobops.conrollers;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HealthCheckController {

    @GetMapping("/api/health")
    public ResponseEntity<Map> healthCheck(){
        Map<String, String> healthCheckMap = new HashMap<>();
        healthCheckMap.put("healthCheck","success");


        return ResponseEntity.ok()
                .cacheControl(CacheControl.noCache())
                .body(healthCheckMap);
    }
}
