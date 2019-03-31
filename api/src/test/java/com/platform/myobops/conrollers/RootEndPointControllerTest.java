package com.platform.myobops.conrollers;

import com.platform.myobops.services.APIService;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class RootEndPointControllerTest {

    @Autowired
    RootEndPointController rootEndPointController;

    @Mock
    APIService apiService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getResult() {

        given(apiService.sendAPIData()).willReturn(any(String.class));
        ResponseEntity<?> responseData = rootEndPointController.getResult();
        assertThat(responseData.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}