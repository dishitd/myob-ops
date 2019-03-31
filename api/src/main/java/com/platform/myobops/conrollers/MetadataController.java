package com.platform.myobops.conrollers;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@Getter
@Setter
@CrossOrigin(origins = "*")
public class MetadataController {

    @Value("${application.version}")
    private String applicationVersion;

    @Value("${application.description}")
    private String applicationDescription;

    @Value("${git.commit.id}")
    private String lastGitCommit;


    @GetMapping("/api/metadata")
    public ResponseEntity<Map> sendMetadata() {
//        List<Map<String, String>> metadataList = new ArrayList();
        Map<String, String> metadataMap = new HashMap<>();


        metadataMap.put("version", applicationVersion);
        metadataMap.put("description", applicationDescription);
        metadataMap.put("lastCommit", lastGitCommit);
        // TODO: Get latest commit

//        metadataList.add(metadataMap);
        return ResponseEntity.ok().cacheControl(CacheControl.noCache())
                .body(metadataMap);
    }
}
