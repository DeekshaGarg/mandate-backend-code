package com.example.restfulservices.controller;

import com.example.restfulservices.model.HelloWorldBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloWorldControllerTest {

    private HelloWorldController helloWorldControllerUnderTest;

    @BeforeEach
    void setUp() {
        helloWorldControllerUnderTest = new HelloWorldController();
    }

    @Test
    void testHelloWorld() {
        // Setup

        // Run the test
        final String result = helloWorldControllerUnderTest.helloWorld();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    void testHelloWorldBean() {
        // Setup

        // Run the test
        final HelloWorldBean result = helloWorldControllerUnderTest.helloWorldBean();

        // Verify the results
    }
}
