package com.ssb.reactj;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloGeneratorRestControllerTest {

    @Autowired
    HelloGeneratorRestController controller;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sendThemAHello() {
        assertThat(controller).isNotNull();
        // sending 1 now
        ResponseEntity res1 = controller.sendThemAHello(1);
        assertThat(res1.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat((String) res1.getBody()).isEqualTo("Hello");
        // sending 5 now
        ResponseEntity res5 = controller.sendThemAHello(5);
        assertThat(res5.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat((String) res5.getBody()).isEqualTo("Hello-Hello-Hello-Hello-Hello");
        // sending 6 now
        ResponseEntity res6 = controller.sendThemAHello(6);
        assertThat(res6.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}