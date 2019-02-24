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

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class RootEndPointControllerTest {

    @Autowired
    RootEndPointController rootEndPointController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getResult() {

        ResponseEntity<?> responseData = rootEndPointController.getResult();
        assertThat(responseData.getStatusCode()).isEqualTo(HttpStatus.OK);


        assertThat(responseData.getBody().toString().contains("API Works!")).isTrue();
    }
}