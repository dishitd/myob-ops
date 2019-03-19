package com.platform.myobops.conrollers;

import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class MetadataControllerTest {

    @Autowired
    MetadataController metadataController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void sendMetadata() {
        ResponseEntity<List> responseList = metadataController.sendMetadata();
        assertThat(responseList.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseList.getBody().size()).isEqualTo(1);

    }
}